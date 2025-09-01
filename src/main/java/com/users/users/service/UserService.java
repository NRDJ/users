package com.users.users.service;

import com.users.users.api.response.UserView;
import com.users.users.model.Address;
import com.users.users.model.Role;
import com.users.users.model.User;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        Role admin = new Role(1L, "ADMIN");
        Role customer = new Role(2L, "CUSTOMER");
        Role editor = new Role(3L, "EDITOR");

        users.add(
            new User(
                1L, "Pedro Pablo", "pedro@example.com", hash("Pedro123!"),
                List.of(customer),
                List.of(new Address("Av. Siempre Viva 123", "Temuco", "Padre Las Casas", "Araucanía", "4810000")),
                LocalDateTime.now().minusDays(10)
            )
        );

        users.add(
            new User(
                2L, "Benito Rojas", "benito@example.com", hash("Benito#2024"),
                List.of(customer),
                List.of(new Address("Los Alerces 456", "Temuco", "Temuco", "Araucanía", "4810200")),
                LocalDateTime.now().minusDays(9)
            )
        );

        users.add(
            new User(
                3L, "Carla Gómez", "carla@example.com", hash("Carla*789"),
                List.of(editor, customer),
                List.of(new Address("Colo Colo 789", "Santiago", "Ñuñoa", "RM", "7750000")),
                LocalDateTime.now().minusDays(8)
            )
        );

        users.add(
            new User(
                4L, "Diego Silva", "diego@example.com", hash("Diego_456"),
                List.of(admin),
                List.of(new Address("Av. Alemania 1000", "Temuco", "Temuco", "Araucanía", "4810500")),
                LocalDateTime.now().minusDays(7)
            )
        );

        users.add(
            new User(
                5L, "Elisa Mella", "elisa@example.com", hash("Elisa%159"),
                List.of(customer),
                List.of(new Address("Prat 321", "Valdivia", "Valdivia", "Los Ríos", "5090000")),
                LocalDateTime.now().minusDays(6)
            )
        );

        users.add(
            new User(
                6L, "Fabián Torres", "fabian@example.com", hash("Fabian_001"),
                List.of(customer),
                List.of(new Address("O'Higgins 222", "Temuco", "Padre Las Casas", "Araucanía", "4810001")),
                LocalDateTime.now().minusDays(5)
            )
        );

        users.add(
            new User(
                7L, "Gabriela Díaz", "gaby@example.com", hash("Gaby-777"),
                List.of(editor),
                List.of(new Address("Lautaro 456", "Concepción", "Concepción", "Biobío", "4030000")),
                LocalDateTime.now().minusDays(4)
            )
        );

        users.add(
            new User(
                8L, "Héctor Fuentes", "hector@example.com", hash("H3ctor!"),
                List.of(customer, editor),
                List.of(new Address("Los Robles 987", "Temuco", "Temuco", "Araucanía", "4810600")),
                LocalDateTime.now().minusDays(3)
            )
        );
    }

    private String hash(String plain) {
        return Base64.getEncoder().encodeToString(("salt:" + plain).getBytes());
    }

    public List<UserView> getAll() {
        return users.stream().map(this::toView).collect(Collectors.toList());
    }

    public Optional<UserView> getById(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .map(this::toView);
    }

    public Optional<UserView> getByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .map(this::toView);
    }

    public Optional<User> findEntityByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public List<String> getRoles(Long userId) {
        return users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .map(u -> u.getRoles().stream().map(Role::getName).toList())
                .orElse(List.of());
    }

    public List<Address> getAddresses(Long userId) {
        return users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .map(User::getAddresses)
                .orElse(List.of());
    }

    private UserView toView(User u) {
        return new UserView(
                u.getId(),
                u.getName(),
                u.getEmail(),
                u.getRoles(),
                u.getAddresses(),
                u.getCreatedAt()
        );
    }
}
