package com.example.employeeapi.service;

import com.example.employeeapi.dto.EmployeeRequestDTO;
import com.example.employeeapi.dto.EmployeeResponseDTO;
import com.example.employeeapi.entity.EmployeeEntity;
import com.example.employeeapi.exception.ResourceNotFoundException;
import com.example.employeeapi.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }


    // ---------- Mapper ----------
    private EmployeeResponseDTO toDTO(EmployeeEntity emp) {
        return new EmployeeResponseDTO(
                emp.getId(),
                emp.getName(),
                emp.getEmail(),
                emp.getDepartment(),
                emp.getGender(),
                emp.getStatus()
        );
    }

    // ---------- CREATE ----------
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
        EmployeeEntity e = new EmployeeEntity();
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setDepartment(dto.getDepartment());
        e.setGender(dto.getGender());
        e.setStatus(dto.getStatus());
        return toDTO(repo.save(e));
    }

    // ---------- UPDATE ----------
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {

        EmployeeEntity e = repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + id));

        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setDepartment(dto.getDepartment());
        e.setGender(dto.getGender());
        e.setStatus(dto.getStatus());

        return toDTO(repo.save(e));
    }

    // ---------- GET BY ID ----------
    public EmployeeResponseDTO getEmployeeById(Long id) {
        return repo.findById(id)
                .map(this::toDTO)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with id " + id));
    }

    // ---------- LIST + PAGINATION ----------
    public Page<EmployeeResponseDTO> searchEmployees(
            String keyword,
            int page,
            int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        // If no search text → return all
        if (keyword == null || keyword.isBlank()) {
            return repo.findAll(pageable)
                    .map(this::toDTO);
        }

        // 🔹 Search in name OR email OR department
        return repo
                .findByNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrDepartmentContainingIgnoreCase(
                        keyword, keyword, keyword, pageable
                )
                .map(this::toDTO);
    }


    // ---------- DELETE ----------
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}
