package com.example.studentrecords.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StudentDto {
        private final String email;
        private final String name;
        private final Integer roll;
        private final Integer age;
}
