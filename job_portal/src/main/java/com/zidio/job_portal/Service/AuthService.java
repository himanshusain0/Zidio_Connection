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


    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);

        String token = jwtUtil.generateToken( user.getEmail(),user.getRole().name());
        return  new AuthResponse(token);


    }


    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));


        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid credentials");

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token);


    }

}
