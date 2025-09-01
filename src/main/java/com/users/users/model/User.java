package com.users.users.model;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String email;
    private String passwordHash;
    private List<Role> roles;
    private List<Address> addresses;
    private LocalDateTime createdAt;

    public User() {}

    public User(Long id,
                String name,
                String email,
                String passwordHash,
                List<Role> roles,
                List<Address> addresses,
                LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles;
        this.addresses = addresses;
        this.createdAt = createdAt;
    }

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) { 
        this.name = name; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPasswordHash() { 
        return passwordHash; 
    }
    public void setPasswordHash(String passwordHash) { 
        this.passwordHash = passwordHash; 
    }

    public List<Role> getRoles() { 
        return roles; 
    }
    public void setRoles(List<Role> roles) { 
        this.roles = roles; 
    }

    public List<Address> getAddresses() { 
        return addresses; 
    }
    public void setAddresses(List<Address> addresses) { 
        this.addresses = addresses; 
    }

    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
    public void setCreatedAt(LocalDateTime createdAt) { 
        this.createdAt = createdAt; 
    }
}
