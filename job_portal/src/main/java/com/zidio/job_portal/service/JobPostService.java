package com.zidio.job_portal.service;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.zidio.job_portal.repository.JobPostRepository;
import com.zidio.job_portal.entity.JobPost;
import com.zidio.job_portal.Enum.JobType;
import com.zidio.job_portal.dto.JobPostDTO;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public JobPost createJob(JobPostDTO dto) {
        JobPost job = JobPost.builder()
                .companyName(dto.getCompanyName())
                .jobDescription(dto.getJobDescription())
                .jobLocation(dto.getJobLocation())
                .jobTitle(dto.getJobTitle())
                .jobType(dto.getJobType())
                .postedDate(dto.getPostedDate())
                .deadLineDate(dto.getDeadLineDate())
                .recruiterEmail(dto.getRecruiterEmail())
                .build();

        return jobPostRepository.save(job);
    }
    public List<JobPost> getAllJobs() {
        return jobPostRepository.findAll();
    }

    public List<JobPost> getJobByRecruiter(String recruiterEmail) {
        return jobPostRepository.findByRecruiterEmail(recruiterEmail);
    }

    public List<JobPost> searchJobByCompanyName(String companyName) {
        return jobPostRepository.findByCompanyName(companyName);
    }

    public List<JobPost> searchJobByJobTitle(String jobTitle) {
        return jobPostRepository.findByJobTitle(jobTitle);
    }

    public List<JobPost> searchJobByJobType(JobType jobType) {
        return jobPostRepository.findByJobType(jobType);
    }

    public List<JobPost> searchJobByJobLocation(String jobLocation) {
        return jobPostRepository.findByJobLocation(jobLocation);
    }
}