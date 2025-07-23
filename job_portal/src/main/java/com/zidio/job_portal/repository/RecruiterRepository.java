package com.zidio.job_portal.repository;

import com.zidio.job_portal.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {

    Optional<Recruiter > findByEmail(String recruiterEmail);
}
