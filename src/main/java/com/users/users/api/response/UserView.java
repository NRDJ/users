package com.users.users.api.response;

import com.users.users.model.Address;
import com.users.users.model.Role;
import java.time.LocalDateTime;
import java.util.List;

public class UserView {
    private Long id;
    private String name;
    private String email;
    private List<Role> roles;
    private List<Address> addresses;
    private LocalDateTime createdAt;

    public UserView(Long id,
                    String name,
                    String email,
                    List<Role> roles,
                    List<Address> addresses,
                    LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.addresses = addresses;
        this.createdAt = createdAt;
    }

    public Long getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    public String getEmail() { 
        return email; 
    }

    public List<Role> getRoles() { 
        return roles; 
    }

    public List<Address> getAddresses() { 
        return addresses; 
    }

    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
}
