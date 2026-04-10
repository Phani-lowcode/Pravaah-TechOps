package com.lowcodelabs.techops.services;

import com.lowcodelabs.techops.models.Category;
import com.lowcodelabs.techops.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    // Get by ID
    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    // Search by name
    public List<Category> searchByName(String name) {
        return categoryRepository.findByNameContainingIgnoreCase(name);
    }

    // Filter by active status
    public List<Category> filterByActive(Boolean isActive) {
        return categoryRepository.findByIsActive(isActive);
    }

    // Create new category
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    // Update existing category
    public Category update(Long id, Category updated) {
        updated.setId(id);
        return categoryRepository.save(updated);
    }

    // Delete category
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}