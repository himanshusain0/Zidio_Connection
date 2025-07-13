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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String password;

    private String confirmPassword;

    private Role role; // STUDENT, RECRUITER, ADMIN

    private String phone; // optional
}
