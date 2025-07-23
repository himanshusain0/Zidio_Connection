package com.zidio.job_portal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruiter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recruiterName;
    private String companyName;

    @Column(unique = true)
    private String email;  // Consistent with DTO

    private String phone;  // Consistent with DTO
    private String designation;
}