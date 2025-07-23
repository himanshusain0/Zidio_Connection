package com.zidio.job_portal.controller;

import com.zidio.job_portal.dto.AdminDTO;
import com.zidio.job_portal.dto.SystemStatusDTO;
import com.zidio.job_portal.dto.UserStatusUpdateDTO;
import com.zidio.job_portal.Enum.Role;
import com.zidio.job_portal.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins/")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/users")
    public ResponseEntity<List<AdminDTO>>getAllUsers(){
        return  ResponseEntity.ok(adminService.getAllUsers());

    }

    @GetMapping("users/role")
    public ResponseEntity<List<AdminDTO>>getUsersByRole(@RequestParam Role role){
        return ResponseEntity.ok(adminService.getUserByRole(role));
    }

    @PutMapping("/users/status")
    public ResponseEntity<AdminDTO> updateUserStatus(@RequestBody UserStatusUpdateDTO dto) {
        return ResponseEntity.ok(adminService.updateUserStatus(dto));
    }

    @GetMapping("/status")
    public ResponseEntity<SystemStatusDTO>getSystemStatus(){
        return ResponseEntity.ok(adminService.getSystemStatus());
    }




}

