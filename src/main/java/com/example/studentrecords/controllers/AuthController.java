package com.example.studentrecords.controllers;

import com.example.studentrecords.dto.JwtDto;
import com.example.studentrecords.dto.LoginDto;
import com.example.studentrecords.services.AuthServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthServiceImplementation authService;

    public AuthController(AuthServiceImplementation authService){
        this.authService=authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginDto loginDto){
        String token = authService.login123(loginDto);
        JwtDto jwtResponse = new JwtDto();
        jwtResponse.setAccessToken(token);
        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }
}
