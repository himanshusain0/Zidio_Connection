package com.zidio.job_portal.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemStatusDTO {

    private  int totalUsers;
    private  int totlRecruiters;
    private  int totalEmployees;
    private  int totalJobPosts;
    private  int totalApplicatiions;

}
