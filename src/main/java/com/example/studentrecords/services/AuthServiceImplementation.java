package com.example.studentrecords.services;

import com.example.studentrecords.dto.LoginDto;
import com.example.studentrecords.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImplementation  {
private AuthenticationManager authenticationManager;
private JwtTokenProvider jwtTokenProvider;
    public String login123(LoginDto loginDto){
    System.out.println("cae");
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.getUsernameOrEmail(),
            loginDto.getPassword()
    ));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtTokenProvider.generateJwtToken(authentication);
    return  token;
}
}

