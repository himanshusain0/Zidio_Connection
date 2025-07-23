package com.zidio.job_portal.entity;

import com.zidio.job_portal.Enum.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="applications")
@Data
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long jobId;
    private String employeeEmail;
    private String recruiterEmail;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private String resumeURL;

}
