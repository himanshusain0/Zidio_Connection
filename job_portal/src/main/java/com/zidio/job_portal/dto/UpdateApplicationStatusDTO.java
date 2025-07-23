package com.zidio.job_portal.dto;

import com.zidio.job_portal.Enum.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationStatusDTO {
    private Long applicationId;
    private ApplicationStatus status;
}
