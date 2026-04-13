package com.lowcodelabs.techops.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color;
    private boolean active;

    @ManyToOne
    @JoinTable(
        name = "org_department_mapping",           // The separate table name
        joinColumns = @JoinColumn(name = "department_id"),      // Column for this entity
        inverseJoinColumns = @JoinColumn(name = "organization_id") // Column for his entity
    )
    private Organization organization;
}