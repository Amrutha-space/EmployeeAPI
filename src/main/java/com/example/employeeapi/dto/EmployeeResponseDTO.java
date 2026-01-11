package com.example.employeeapi.dto;

import com.example.employeeapi.entity.EmployeeEntity;

public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String department;
    private String gender;
    private String status;

    public EmployeeResponseDTO() {}

    public EmployeeResponseDTO(Long id, String name, String email,
                               String department, String gender, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.gender = gender;
        this.status = status;
    }

    public EmployeeResponseDTO(EmployeeEntity e) {
        this(e.getId(), e.getName(), e.getEmail(),
                e.getDepartment(), e.getGender(), e.getStatus());
    }

    // --- getters ---
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartment() { return department; }
    public String getGender() { return gender; }
    public String getStatus() { return status; }

    // --- setters ---
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setDepartment(String department) { this.department = department; }
    public void setGender(String gender) { this.gender = gender; }
    public void setStatus(String status) { this.status = status; }
}
