package com.zidio.job_portal.dto;

import com.zidio.job_portal.Enum.JobType;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobPostDTO {
    private  Long id;
    private String recruiterEmail;
    private String companyName;
    private String jobTitle;
    private JobType  jobType;
    private String jobDescription;
    private String jobLocation;
    private LocalDate postedDate;
    private LocalDate deadLineDate;

}
