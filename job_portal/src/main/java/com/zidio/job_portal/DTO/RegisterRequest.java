package com.zidio.job_portal.DTO;
import com.zidio.job_portal.Enum.Role;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RegisterRequest {
    private String name;

    private String email; // also used as username

    private String password;

    private String confirmPassword;

    private Role role; // STUDENT, RECRUITER, ADMIN

    private String phone; // optional
}
