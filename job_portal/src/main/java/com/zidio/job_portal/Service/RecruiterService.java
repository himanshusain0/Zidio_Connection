package com.zidio.job_portal.Service;

import com.zidio.job_portal.DTO.RecruiterDTO;
import com.zidio.job_portal.Entity.Recruiter;
import com.zidio.job_portal.Exception.ResourceNotFoundException;
import com.zidio.job_portal.Repository.RecruiterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecruiterService {

    private final RecruiterRepository recruiterRepository;

    @Transactional
    public RecruiterDTO createOrUpdateRecruiter(RecruiterDTO dto) {
        Optional<Recruiter> existing = recruiterRepository.findByEmail(dto.getEmail());

        Recruiter recruiter = existing.orElseGet(Recruiter::new);

        // Only set ID for new entities
        if (existing.isEmpty()) {
            recruiter.setId(dto.getId());
        }

        recruiter.setRecruiterName(dto.getRecruiterName());
        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setEmail(dto.getEmail());
        recruiter.setPhone(dto.getPhone());
        recruiter.setDesignation(dto.getDesignation());

        Recruiter savedRecruiter = recruiterRepository.save(recruiter);
        return mapToDTO(savedRecruiter);
    }

    @Transactional(readOnly = true)
    public RecruiterDTO getRecruiterByEmail(String email) {
        Recruiter recruiter = recruiterRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Recruiter not found with email: " + email));
        return mapToDTO(recruiter);
    }

    private RecruiterDTO mapToDTO(Recruiter recruiter) {
        return RecruiterDTO.builder()
                .id(recruiter.getId())
                .recruiterName(recruiter.getRecruiterName())
                .companyName(recruiter.getCompanyName())
                .email(recruiter.getEmail())
                .phone(recruiter.getPhone())
                .designation(recruiter.getDesignation())
                .build();
    }
}