package com.lowcodelabs.techops.repositories;

import com.lowcodelabs.techops.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    // Find by exact name
    List<Organization> findByOrgName(String orgName);

    // Find by name containing (partial search)
    List<Organization> findByOrgNameContainingIgnoreCase(String orgName);

}

// JpaRepository already gives us for free:
// save() → Create & Update
// findAll() → Get all
// findById() → Get by ID
// deleteById() → Delete