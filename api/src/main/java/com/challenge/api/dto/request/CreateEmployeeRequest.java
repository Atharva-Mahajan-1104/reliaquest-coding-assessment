package com.challenge.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request object used for employee creation operations.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull(message = "Salary is required") @Min(value = 0, message = "Salary cannot be negative")
    @Max(value = 10000000, message = "Salary exceeds allowed limit")
    private Integer salary;

    @NotNull(message = "Age is required") @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age exceeds allowed limit")
    private Integer age;

    @NotBlank(message = "Job title is required")
    @Size(min = 2, max = 100, message = "Job title must be between 2 and 100 characters")
    private String jobTitle;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Contract hire date is required") @PastOrPresent(message = "Contract hire date cannot be in the future")
    private Instant contractHireDate;

    @Future(message = "Contract termination date must be in the future")
    private Instant contractTerminationDate;
}
