package com.zidio.job_portal.Repository;

import com.zidio.job_portal.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long > {
    Employee findByEmail(String email);

}
