package com.zidio.job_portal.Entity;

import com.zidio.job_portal.Enum.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    private Role role;
}

