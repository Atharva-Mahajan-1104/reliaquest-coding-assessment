package com.challenge.api.controller;

import com.challenge.api.dto.request.CreateEmployeeRequest;
import com.challenge.api.dto.response.EmployeeResponse;
import com.challenge.api.service.EmployeeService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller exposing employee management endpoints.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {

        List<EmployeeResponse> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<EmployeeResponse> getEmployeeByUuid(@PathVariable("uuid") UUID uuid) {

        EmployeeResponse employee = employeeService.getEmployeeByUuid(uuid);

        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {

        EmployeeResponse createdEmployee = employeeService.createEmployee(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }
}
