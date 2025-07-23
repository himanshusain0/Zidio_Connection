package com.zidio.job_portal.service;


import com.zidio.job_portal.dto.AdminDTO;
import com.zidio.job_portal.dto.SystemStatusDTO;
import com.zidio.job_portal.dto.UserStatusUpdateDTO;
import com.zidio.job_portal.entity.Admin;
import com.zidio.job_portal.Enum.Role;
import com.zidio.job_portal.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AdminService {

    private  final AdminRepository adminRepository;
    private final UserRepository userRepository;          // Add this
    private final EmployeeRepository employeeRepository;  // Add this
    private final RecruiterRepository recruiterRepository; // Add this
    private final JobPostRepository jobPostRepository;    // Add this
    private final ApplicationRepository applicationRepository; // Add this



    public List<AdminDTO> getAllUsers(){
        return adminRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }
    public List<AdminDTO>getUserByRole(Role role){
        return adminRepository.findByRole(role).stream().map(this::toDTO).collect(Collectors.toList());

    }
    public AdminDTO updateUserStatus(UserStatusUpdateDTO dto) {

        Optional<Admin> optional=adminRepository.findById(dto.getUserId());
        if(!optional.isPresent()) {
            throw new  RuntimeException("user not found");
        }
        Admin user=optional.get();
        user.setActive(dto.isActive());
        adminRepository.save(user);

        return toDTO(user);

    }
    public SystemStatusDTO getSystemStatus() {
        int totalUsers=(int)adminRepository.count();
        int totalEmployees=(int)adminRepository.count();
        int totalRecruiters=(int)adminRepository.count();
        int totalJobPosts=(int)adminRepository.count();
        int totalApplications=(int)adminRepository.count();

        SystemStatusDTO status = new SystemStatusDTO();
        status.setTotalUsers(totalUsers);
        status.setTotalEmployees(totalEmployees);
        status.setTotlRecruiters(totalRecruiters);
        status.setTotalJobPosts(totalJobPosts);
        status.setTotalApplicatiions(totalApplications);

        return status;
    }

    private AdminDTO toDTO(Admin admin) {
        AdminDTO dto =new AdminDTO();
        dto.setId(admin.getId());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());
        dto.setActive(admin.isActive());

        return dto;

    }


}
