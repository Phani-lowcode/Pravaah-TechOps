package com.lowcodelabs.techops.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_index")
    private Integer order;

    @Column(name = "org_name", nullable = false)
    private String orgName;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "brand_primary")
    private String brandPrimary;

    @Column(name = "brand_secondary")
    private String brandSecondary;

    @Column(name = "header_background")
    private String headerBackground;

    @Column(name = "upload_image")
    private String uploadImage;

    @ManyToMany
    @JoinTable(
        name = "organization_country",
        joinColumns = @JoinColumn(name = "organization_id"),
        inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries;

    // Getters
    public Long getId() { return id; }
    public Integer getOrder() { return order; }
    public String getOrgName() { return orgName; }
    public Boolean getIsActive() { return isActive; }
    public String getBrandPrimary() { return brandPrimary; }
    public String getBrandSecondary() { return brandSecondary; }
    public String getHeaderBackground() { return headerBackground; }
    public String getUploadImage() { return uploadImage; }
    public List<Country> getCountries() { return countries; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setOrder(Integer order) { this.order = order; }
    public void setOrgName(String orgName) { this.orgName = orgName; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public void setBrandPrimary(String brandPrimary) { this.brandPrimary = brandPrimary; }
    public void setBrandSecondary(String brandSecondary) { this.brandSecondary = brandSecondary; }
    public void setHeaderBackground(String headerBackground) { this.headerBackground = headerBackground; }
    public void setUploadImage(String uploadImage) { this.uploadImage = uploadImage; }
    public void setCountries(List<Country> countries) { this.countries = countries; }
}