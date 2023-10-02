package com.example.jpatest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyid")
    private int propertyId;
    @Column(name = "productid", updatable = false, insertable = false)
    private int productId;
    @Column(name = "propertyname")
    private String propertyName;
    @Column(name = "propertysort")
    private int propertySort;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productid")
    private Products products;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "properties")
    @JsonManagedReference
    private List<PropertyDetails> propertyDetails;

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertySort() {
        return propertySort;
    }

    public void setPropertySort(int propertySort) {
        this.propertySort = propertySort;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public List<PropertyDetails> getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(List<PropertyDetails> propertyDetails) {
        this.propertyDetails = propertyDetails;
    }
}
