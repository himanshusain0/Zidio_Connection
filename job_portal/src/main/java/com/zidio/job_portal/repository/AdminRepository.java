package com.zidio.job_portal.repository;

import com.zidio.job_portal.entity.Admin;
import com.zidio.job_portal.Enum.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    List<Admin> findByRole(Role role);
    Optional<Admin> findById(Long id);

}
