package com.lowcodelabs.techops.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "color")
    private String color;

    @NotNull(message = "Active status is required")
    @Column(name = "is_active")
    private Boolean isActive = true;

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getColor() { return color; }
    public Boolean getIsActive() { return isActive; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setColor(String color) { this.color = color; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}