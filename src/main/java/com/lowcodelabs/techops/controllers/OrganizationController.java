package com.lowcodelabs.techops.controllers;

import com.lowcodelabs.techops.models.Organization;
import com.lowcodelabs.techops.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    // GET all organizations
    @GetMapping
    public ResponseEntity<List<Organization>> getAll() {
        return ResponseEntity.ok(organizationService.getAll());
    }

    // GET organization by ID
    @GetMapping("/{id}")
    public ResponseEntity<Organization> getById(@PathVariable Long id) {
        Optional<Organization> organization = organizationService.getById(id);
        return organization.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new organization
    @PostMapping
    public ResponseEntity<Organization> create(@RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.create(organization));
    }

    // PUT update organization
    @PutMapping("/{id}")
    public ResponseEntity<Organization> update(@PathVariable Long id, 
                                               @RequestBody Organization organization) {
        return ResponseEntity.ok(organizationService.update(id, organization));
    }

    // DELETE organization
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        organizationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET by exact name
    @GetMapping("/name/{orgName}")
    public ResponseEntity<List<Organization>> getByOrgName(@PathVariable String orgName) {
        return ResponseEntity.ok(organizationService.getByOrgName(orgName));
    }

    // GET by name search (partial)
    @GetMapping("/search")
    public ResponseEntity<List<Organization>> searchByOrgName(@RequestParam String orgName) {
        return ResponseEntity.ok(organizationService.searchByOrgName(orgName));
    }

}