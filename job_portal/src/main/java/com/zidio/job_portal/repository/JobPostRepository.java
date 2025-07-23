package com.zidio.job_portal.repository;

import com.zidio.job_portal.entity.JobPost;
import com.zidio.job_portal.Enum.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    List<JobPost>findByCompanyName(String companyName);
    List<JobPost>findByJobTitle(String jobTitle);
    List<JobPost>findByJobType(JobType jobType);
    List<JobPost> findByJobLocation(String jobLocation);
    List<JobPost> findByRecruiterEmail(String recruiterEmail);

}
