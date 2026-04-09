package com.lowcodelabs.techops.services;

import com.lowcodelabs.techops.models.Country;
import com.lowcodelabs.techops.repositeries.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    // Get all countries
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    // Get by ID
    public Optional<Country> getById(Long id) {
        return countryRepository.findById(id);
    }

    // Search by name
    public List<Country> searchByName(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    // Filter by active status
    public List<Country> filterByActive(Boolean isActive) {
        return countryRepository.findByIsActive(isActive);
    }

    // Create new country
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    // Update existing country
    public Country update(Long id, Country updated) {
        updated.setId(id);
        return countryRepository.save(updated);
    }

    // Delete country
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}