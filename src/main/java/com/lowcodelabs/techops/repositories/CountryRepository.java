package com.lowcodelabs.techops.repositories;

import com.lowcodelabs.techops.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    // Search by name — for search box in UI
    List<Country> findByNameContainingIgnoreCase(String name);

    // Filter by active status — for dropdown filter in UI
    List<Country> findByIsActive(Boolean isActive);
}