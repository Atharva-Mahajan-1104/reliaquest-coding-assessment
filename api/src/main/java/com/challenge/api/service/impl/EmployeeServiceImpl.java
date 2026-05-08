package com.challenge.api.service.impl;

import com.challenge.api.dto.request.CreateEmployeeRequest;
import com.challenge.api.dto.response.EmployeeResponse;
import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import com.challenge.api.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    /**
     * Creates a full name using first and last name.
     */
    private String buildFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    /**
     * Maps an employee entity to a response object.
     */
    private EmployeeResponse mapToEmployeeResponse(Employee employee) {

        return new EmployeeResponse(
                employee.getUuid(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getFullName(),
                employee.getSalary(),
                employee.getAge(),
                employee.getJobTitle(),
                employee.getEmail(),
                employee.getContractHireDate(),
                employee.getContractTerminationDate());
    }
    
    /**
     * Loads sample employee data on startup.
     */
    @PostConstruct
    public void loadMockEmployees() {

        final Employee employee1 = new EmployeeImpl(
                UUID.randomUUID(),
                "John",
                "Doe",
                buildFullName("John", "Doe"),
                75000,
                30,
                "Backend Developer",
                "john.doe@example.com",
                Instant.now(),
                null);

        final Employee employee2 = new EmployeeImpl(
                UUID.randomUUID(),
                "Jane",
                "Smith",
                buildFullName("Jane", "Smith"),
                82000,
                28,
                "Software Engineer",
                "jane.smith@example.com",
                Instant.now(),
                null);

        employees.add(employee1);
        employees.add(employee2);
    }

    /**
     * Retrieves all available employees.
     *
     * @return list of employees
     */
    @Override
    public List<EmployeeResponse> getAllEmployees() {

        return employees.stream().map(this::mapToEmployeeResponse).toList();
    }

    /**
     * Retrieves an employee using the provided UUID.
     *
     * @param uuid employee identifier
     * @return matching employee
     */
    @Override
    public EmployeeResponse getEmployeeByUuid(UUID uuid) {

        Employee employee = employees.stream()
                .filter(emp -> emp.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));

        return mapToEmployeeResponse(employee);
    }

    /**
     * Creates a new employee using the provided request data.
     *
     * @param request employee creation request
     * @return newly created employee
     */
    @Override
    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {

        final Employee employee = new EmployeeImpl(
                UUID.randomUUID(),
                request.getFirstName(),
                request.getLastName(),
                buildFullName(request.getFirstName(), request.getLastName()),
                request.getSalary(),
                request.getAge(),
                request.getJobTitle(),
                request.getEmail(),
                request.getContractHireDate(),
                null);

        employees.add(employee);

        return mapToEmployeeResponse(employee);
    }
}
