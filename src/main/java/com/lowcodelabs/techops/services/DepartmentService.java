package com.lowcodelabs.techops.services;

import com.lowcodelabs.techops.models.Department;
import com.lowcodelabs.techops.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Fix for the first error: Define the save method
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    // Fix for the second error: Define the getAll method
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}