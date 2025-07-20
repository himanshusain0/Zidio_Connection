package com.zidio.job_portal.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterDTO {
    private Long id;
    private String recruiterName;
    private String companyName;
    private String email;  // Changed from recruiterEmail to match entity
    private String phone;  // Changed from recruiterPhone
    private String designation;
}