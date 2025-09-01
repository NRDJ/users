package com.users.users.api.response;

public class AuthResponse {
    private boolean authenticated;
    private String token;
    private String message;

    public AuthResponse(boolean authenticated, String token, String message) {
        this.authenticated = authenticated;
        this.token = token;
        this.message = message;
    }

    public boolean isAuthenticated() { return authenticated; }
    public String getToken() { return token; }
    public String getMessage() { return message; }
}