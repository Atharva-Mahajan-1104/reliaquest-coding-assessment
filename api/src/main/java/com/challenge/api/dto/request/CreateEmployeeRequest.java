package com.challenge.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Salary is required") 
    @Min(value = 0, message = "Salary cannot be negative")
    private Integer salary;

    @NotNull(message = "Age is required") 
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Contract hire date is required") private Instant contractHireDate;
}
