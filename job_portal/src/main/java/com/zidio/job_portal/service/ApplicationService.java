package com.zidio.job_portal.service;

import com.zidio.job_portal.Enum.ApplicationStatus;
import com.zidio.job_portal.dto.ApplicationDTO;
import com.zidio.job_portal.dto.UpdateApplicationStatusDTO;
import com.zidio.job_portal.entity.Application;
import com.zidio.job_portal.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationDTO applyJob(ApplicationDTO dto) {
        Application app = new Application();
        app.setJobId(dto.getJobId());
        app.setEmployeeEmail(dto.getEmployeeEmail());
        app.setRecruiterEmail(dto.getRecruiterEmail());
        app.setStatus(ApplicationStatus.APPLIED);
        app.setResumeURL(dto.getResumeURL());

        applicationRepository.save(app);
        return mapToDTO(app);
    }

    public List<ApplicationDTO> findByEmployeeEmail(String employeeEmail) {
        return applicationRepository.findByEmployeeEmail(employeeEmail)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> findByRecruiterEmail(String recruiterEmail) {
        return applicationRepository.findByRecruiterEmail(recruiterEmail)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<ApplicationDTO> findByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ApplicationDTO updateStatus(UpdateApplicationStatusDTO dto) {
        Optional<Application> optional = applicationRepository.findById(dto.getApplicationId());
        if (!optional.isPresent()) {
            throw new RuntimeException("Application not found");
        }

        Application app = optional.get();
        try {
            app.setStatus(ApplicationStatus.valueOf(dto.getStatus().toString()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid status: " + dto.getStatus());
        }

        applicationRepository.save(app);
        return mapToDTO(app);
    }

    private ApplicationDTO mapToDTO(Application app) {
        return ApplicationDTO.builder()
                .id(app.getId())
                .jobId(app.getJobId())
                .employeeEmail(app.getEmployeeEmail())
                .recruiterEmail(app.getRecruiterEmail())
                .status(app.getStatus())
                .resumeURL(app.getResumeURL())
                .build();
    }
}