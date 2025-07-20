package com.zidio.job_portal.Service;

import com.zidio.job_portal.DTO.EmployeeDTO;
import com.zidio.job_portal.Entity.Employee;
import com.zidio.job_portal.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
   private  EmployeeRepository employeeRepository ;

//    @Override
    public EmployeeDTO getEmployeeByEmail(String email){
        Employee emp = employeeRepository.findByEmail(email);
        if(emp == null) return null;
        return  new EmployeeDTO(
                emp.getId(),
                emp.getEmail(),
                emp.getPhone(),
                emp.getResumeURL(),
                emp.getQualification(),
                emp.getName()
        );
    }
    public EmployeeDTO updateProfile(EmployeeDTO dto){
        Employee emp = employeeRepository.findByEmail(dto.email);
        if(emp == null){
            emp = new Employee();
            emp.setEmail(dto.email);
        }
        emp.setId(dto.id);
        emp.setName(dto.name);
        emp.setEmail(dto.email);
        emp.setPhone(dto.phone);
        emp.setQualification(dto.qualification);
        emp.setResumeURL(dto.resumeURL);
        Employee saved = employeeRepository.save(emp);
        return  new EmployeeDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getPhone(),
                saved.getQualification(),
                saved.getResumeURL()
        );
    }
}
