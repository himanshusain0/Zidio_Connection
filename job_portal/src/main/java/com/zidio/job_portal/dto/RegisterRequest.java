package com.zidio.job_portal.dto;

import com.zidio.job_portal.Enum.Role;

public class RegisterRequest {
    public Long id;
    public String name;
    public String email;
    public String password;
    public Role role;

    public RegisterRequest(Long id, String name, String email, String password, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }


}
