package com.zidio.job_portal.DTO;

import com.zidio.job_portal.Enum.Role;
import lombok.Builder;

@Builder

public class AuthResponse {
    public String token;
    public Role role;
    public String message;

    public AuthResponse(String token) {
        this.token = token;
    }

    public AuthResponse(Role role, String message) {
        this.role = role;
        this.message = message;
    }

    public AuthResponse() {
    }

    public AuthResponse(String token, Role role, String message) {
        this.token = token;
        this.role = role;
        this.message = message;
    }
}
