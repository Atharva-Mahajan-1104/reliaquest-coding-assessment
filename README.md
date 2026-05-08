# ReliaQuest Coding Assessment

## Overview

This project is a Spring Boot REST API for employee management operations.

The API supports:
- Retrieving all employees
- Retrieving an employee by UUID
- Creating a new employee

---

## Architecture

The project follows a layered architecture with separate:
- Controller layer
- Service layer
- DTO layer
- Exception handling layer

Request and response DTOs are used to separate API contracts from internal models.

---

## Validation & Exception Handling

Request validation is implemented using Jakarta Validation annotations.

Global exception handling is implemented using `@RestControllerAdvice` to provide structured validation and error responses.

---

## Mock Data

Employee data is stored in-memory using a list.

Sample employee data is loaded during application startup using `@PostConstruct`.

---

## Formatting

Code formatting and style validation were handled using the Diffplug Spotless Gradle plugin.


---

## Technologies Used

- Java 17
- Spring Boot
- Gradle
- Lombok
- Jakarta Validation

---

## API Endpoints

### Get All Employees

```http
GET /api/v1/employee
```

### Get Employee By UUID

```http
GET /api/v1/employee/{uuid}
```

### Create Employee

```http
POST /api/v1/employee
```
