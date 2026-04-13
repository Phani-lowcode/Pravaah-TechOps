package com.lowcodelabs.techops.repositories;

import com.lowcodelabs.techops.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Make sure this is here!
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}