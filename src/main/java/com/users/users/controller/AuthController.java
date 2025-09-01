package com.users.users.controller;

import com.users.users.api.response.AuthResponse;
import com.users.users.model.User;
import com.users.users.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {

    private final UserService userService;
    public AuthController(UserService userService) { this.userService = userService; }

    @GetMapping("/login")
    public AuthResponse login(
            @RequestParam @NotBlank @Email String email,
            @RequestParam @NotBlank String password
    ) {
        User u = userService.findEntityByEmail(email).orElse(null);
        if (u == null) {
            return new AuthResponse(false, null, "Invalid credentials");
        }

        String expected = Base64.getEncoder()
                .encodeToString(("salt:" + password).getBytes());

        if (!expected.equals(u.getPasswordHash())) {
            return new AuthResponse(false, null, "Invalid credentials");
        }

        String token = Base64.getEncoder()
                .encodeToString((u.getEmail() + ":demoToken").getBytes());

        return new AuthResponse(true, token, "Authenticated");
    }
}
