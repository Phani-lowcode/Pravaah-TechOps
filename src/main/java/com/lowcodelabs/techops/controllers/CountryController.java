package com.lowcodelabs.techops.controllers;

import com.lowcodelabs.techops.models.Country;
import com.lowcodelabs.techops.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin(origins = "*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    // GET all countries
    @GetMapping
    public List<Country> getAll() {
        return countryService.getAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id) {
        return countryService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET search by name — for search box
    @GetMapping("/search")
    public List<Country> search(@RequestParam String name) {
        return countryService.searchByName(name);
    }

    // GET filter by active — for dropdown filter
    @GetMapping("/filter")
    public List<Country> filter(@RequestParam Boolean isActive) {
        return countryService.filterByActive(isActive);
    }

    // POST create new country
    @PostMapping
    public Country create(@RequestBody Country country) {
        return countryService.create(country);
    }

    // PUT update country
    @PutMapping("/{id}")
    public ResponseEntity<Country> update(
            @PathVariable Long id,
            @RequestBody Country country) {
        return countryService.getById(id)
                .map(existing -> ResponseEntity.ok(countryService.update(id, country)))
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE country
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return countryService.getById(id)
                .map(existing -> {
                    countryService.delete(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}