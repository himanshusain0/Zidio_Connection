package com.zidio.job_portal.controller;

import com.zidio.job_portal.dto.JobPostDTO;
import com.zidio.job_portal.entity.JobPost;
import com.zidio.job_portal.Enum.JobType;
import com.zidio.job_portal.service.JobPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/jobposts")
@RequiredArgsConstructor
public class JobPostController {

    private final JobPostService jobPostService;

    @PostMapping
    public ResponseEntity<JobPost> createJobs(@RequestBody JobPostDTO dto) {
        return ResponseEntity.ok(jobPostService.createJob(dto));
    }

    @GetMapping
    public ResponseEntity<List<JobPost>> getAllJobs() {
        return ResponseEntity.ok(jobPostService.getAllJobs());
    }

    @GetMapping("/recruiters/{recruiterEmail}")
    public ResponseEntity<List<JobPost>> getJobByRecruiter(@PathVariable String recruiterEmail) {
        return ResponseEntity.ok(jobPostService.getJobByRecruiter(recruiterEmail));
    }

    @GetMapping("/search/company/{companyName}")
    public ResponseEntity<List<JobPost>> getJobByCompanyName(@PathVariable String companyName) {
        return ResponseEntity.ok(jobPostService.searchJobByCompanyName(companyName));
    }

    @GetMapping("/search/location/{jobLocation}")
    public ResponseEntity<List<JobPost>> getJobByJobLocation(@PathVariable String jobLocation) {
        return ResponseEntity.ok(jobPostService.searchJobByJobLocation(jobLocation));
    }

    @GetMapping("/search/title/{jobTitle}")
    public ResponseEntity<List<JobPost>> getJobByJobTitle(@PathVariable String jobTitle) {
        return ResponseEntity.ok(jobPostService.searchJobByJobTitle(jobTitle));
    }

    @GetMapping("/search/type/{jobType}")
    public ResponseEntity<List<JobPost>> getJobByJobType(@PathVariable JobType jobType) {
        return ResponseEntity.ok(jobPostService.searchJobByJobType(jobType));
    }
}
