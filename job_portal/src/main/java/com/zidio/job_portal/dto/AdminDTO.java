package com.zidio.job_portal.dto;

import com.zidio.job_portal.Enum.Role;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AdminDTO {

    private Long id;
    private String email;
    private Role role;
    private boolean active;

}
