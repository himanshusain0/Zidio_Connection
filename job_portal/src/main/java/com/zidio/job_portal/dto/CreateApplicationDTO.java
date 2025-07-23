package com.zidio.job_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationDTO {

    private Long jobId;
    private String employeeEmail;
    private String recruiterEmail;
    private String resumeURL;
}
