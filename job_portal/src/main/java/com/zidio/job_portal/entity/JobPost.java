package com.zidio.job_portal.entity;


import com.zidio.job_portal.Enum.JobType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jobPost")
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private  String companyName;
    private String jobLocation;
    private JobType jobType;
    private String jobDescription;
    private LocalDate postedDate;
    private LocalDate deadLineDate;
    private String recruiterEmail;



}
