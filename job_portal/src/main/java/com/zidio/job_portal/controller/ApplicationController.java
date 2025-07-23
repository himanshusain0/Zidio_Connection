package com.zidio.job_portal.controller;

import com.zidio.job_portal.dto.ApplicationDTO;
import com.zidio.job_portal.dto.UpdateApplicationStatusDTO;
import com.zidio.job_portal.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<String> apply(@RequestBody ApplicationDTO dto) {
        applicationService.applyJob(dto);
        return ResponseEntity.ok("Application Submitted");
    }

    @GetMapping("/apply")
    public ResponseEntity<String> checkApply() {
        return ResponseEntity.ok("GET request works for testing");
    }

    @GetMapping("/employee/{employeeEmail}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByEmployeeEmail(@PathVariable String employeeEmail) {
        return ResponseEntity.ok(applicationService.findByEmployeeEmail(employeeEmail));
    }

    @GetMapping("/recruiter/{recruiterEmail}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByRecruiterEmail(@PathVariable String recruiterEmail) {
        return ResponseEntity.ok(applicationService.findByRecruiterEmail(recruiterEmail));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.findByJobId(jobId));
    }

    @PutMapping("/status")
    public ResponseEntity<ApplicationDTO> updateStatus(@Valid @RequestBody UpdateApplicationStatusDTO dto) {
        return ResponseEntity.ok(applicationService.updateStatus(dto));
    }
}