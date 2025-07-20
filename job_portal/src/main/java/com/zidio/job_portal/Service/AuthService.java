package com.zidio.job_portal.Service;

import com.zidio.job_portal.DTO.AuthResponse;
import com.zidio.job_portal.DTO.LoginRequest;
import com.zidio.job_portal.DTO.RegisterRequest;
import com.zidio.job_portal.Entity.User;
import com.zidio.job_portal.Repository.UserRepository;
import com.zidio.job_portal.Security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request){
        User user = new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        user.setRole(request.role);
        userRepository.save(user);
        String token = jwtUtil.generateToken(user.getEmail(),user.getRole().name());
        return AuthResponse.builder()
                .token(token)
                .role(user.getRole())
                .message("Registration successful")
                .build();

    }
    public AuthResponse login (LoginRequest request){
        User user = userRepository.findByEmail(request.email).orElseThrow(()-> new RuntimeException("User not found") );
        if(!passwordEncoder.matches(request.password,user.getPassword()))
            throw new RuntimeException("Invalid credentials");
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return AuthResponse.builder()
                .token(token)
                .role(user.getRole())
                .message("Login successful")
                .build();

    }
}
