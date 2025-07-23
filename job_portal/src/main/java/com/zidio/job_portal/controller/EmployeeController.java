package com.zidio.job_portal.controller;

import com.zidio.job_portal.dto.EmployeeDTO;
import com.zidio.job_portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{email}")
    public ResponseEntity<EmployeeDTO>getEmployee(@PathVariable String email){
        return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
    }

    @PostMapping("/update")
    public ResponseEntity<EmployeeDTO>getUpdateProfile(@RequestBody EmployeeDTO dto ){
        return ResponseEntity.ok(employeeService.updateProfile(dto));
    }
}
