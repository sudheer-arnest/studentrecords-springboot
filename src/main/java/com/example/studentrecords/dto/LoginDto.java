package com.example.studentrecords.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    @NotBlank(message = "Username or email cannot be empty")
    private String usernameOrEmail;
    @NotBlank(message = "Password cannot be empty")
    private String password;
}
