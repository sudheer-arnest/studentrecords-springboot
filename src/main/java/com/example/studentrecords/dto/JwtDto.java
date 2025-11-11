package com.example.studentrecords.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtDto {
    private String accessToken;
    private String tokenType = "Bearer";
}
