package com.lowcodelabs.techops.services;

import com.lowcodelabs.techops.models.Organization;
import com.lowcodelabs.techops.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getById(Long id) {
        return organizationRepository.findById(id);
    }

    public Organization create(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization update(Long id, Organization organization) {
        organization.setId(id);
        return organizationRepository.save(organization);
    }

    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }

    // Find by exact name
    public List<Organization> getByOrgName(String orgName) {
        return organizationRepository.findByOrgName(orgName);
    }

    // Find by name containing (partial search)
    public List<Organization> searchByOrgName(String orgName) {
        return organizationRepository.findByOrgNameContainingIgnoreCase(orgName);
    }
}