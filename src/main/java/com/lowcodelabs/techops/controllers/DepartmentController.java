package com.lowcodelabs.techops.controllers;

import com.lowcodelabs.techops.models.Department;
import com.lowcodelabs.techops.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public Department create(@RequestBody Department department) {
        // This calls the 'save' method we just added to the service
        return departmentService.save(department);
    }

    @GetMapping("/all")
    public List<Department> getAll() {
        // This calls the 'getAll' method we just added to the service
        return departmentService.getAll();
    }
}