package com.zidio.job_portal.Controller;

import com.zidio.job_portal.DTO.RecruiterDTO;
import com.zidio.job_portal.Service.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruiters")
@RequiredArgsConstructor
public class RecruiterController {

    private final RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<RecruiterDTO> saveRecruiter(@RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(recruiterService.createOrUpdateRecruiter(dto));
    }

    @GetMapping("/{email}")
    public ResponseEntity<RecruiterDTO> getRecruiter(@PathVariable String email) {
        return ResponseEntity.ok(recruiterService.getRecruiterByEmail(email));
    }
}