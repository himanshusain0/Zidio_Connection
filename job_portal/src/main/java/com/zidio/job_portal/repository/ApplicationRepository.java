package com.zidio.job_portal.repository;


import java.util.List;
import java.util.Optional;

import com.zidio.job_portal.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {

    List<Application> findByEmployeeEmail(String employeeEmail);
    List<Application>findByRecruiterEmail(String recruiterEmail);
    List<Application> findByJobId(Long jobId);
    Optional<Application> findById(Long id);

}
