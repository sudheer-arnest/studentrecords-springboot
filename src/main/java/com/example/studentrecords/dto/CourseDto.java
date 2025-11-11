package com.example.studentrecords.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    @NotBlank(message = "Course title required")
    private String title;
    private String description;
    @NotNull(message = "Credits is required")
    private Integer credits;
}
