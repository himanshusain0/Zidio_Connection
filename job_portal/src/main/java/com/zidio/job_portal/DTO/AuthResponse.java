package com.zidio.job_portal.DTO;

import com.zidio.job_portal.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private Role role;
    private String message;

    public AuthResponse(String token) {
        this.token = token;
    }

//    private String token;
}
