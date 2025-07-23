package com.zidio.job_portal.dto;

import com.zidio.job_portal.Enum.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDTO {

    private Long id;
    private Long jobId;
    private String employeeEmail;
    private String recruiterEmail;
    private ApplicationStatus status;
    private String resumeURL;
}
