package com.zidio.job_portal.entity;

import com.zidio.job_portal.Enum.Role;
import jakarta.persistence.*;
import lombok.*;


//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admins")

public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private Role role;
    private boolean active=true;

}
