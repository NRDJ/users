package com.users.users.controller;

import com.users.users.api.response.UserView;
import com.users.users.model.Address;
import com.users.users.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    @GetMapping
    public List<UserView> all() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserView byId(@PathVariable @Min(1) Long id) {
        return userService.getById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @GetMapping("/by-email")
    public UserView byEmail(@RequestParam @NotBlank @Email String email) {
        return userService.getByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @GetMapping("/{id}/roles")
    public List<String> roles(@PathVariable @Min(1) Long id) {
        return userService.getRoles(id);
    }

    @GetMapping("/{id}/addresses")
    public List<Address> addresses(@PathVariable @Min(1) Long id) {
        return userService.getAddresses(id);
    }
}
