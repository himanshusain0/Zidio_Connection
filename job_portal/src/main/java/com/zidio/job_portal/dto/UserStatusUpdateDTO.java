package com.zidio.job_portal.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class UserStatusUpdateDTO {

    private Long userId;
    private boolean active;
}

