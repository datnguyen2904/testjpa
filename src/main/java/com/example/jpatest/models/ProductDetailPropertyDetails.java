package com.example.jpatest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "productdetailpropertydetails")
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailpropertydetailid")
    private int productDetailPropertyDetailId;
    @Column(name = "productdetailid",  updatable = false, insertable = false)
    private int productDetailId;
    @Column(name = "propertydetailid", updatable = false, insertable = false)
    private int propertyDetailId;
    @Column(name = "productid", updatable = false, insertable = false)
    private int productId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "propertydetailid")
    private PropertyDetails propertyDetails;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productdetailid")
    private ProductDetails productDetails;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "productid")
    private Products products;

    public int getProductDetailPropertyDetailId() {
        return productDetailPropertyDetailId;
    }

    public void setProductDetailPropertyDetailId(int productDetailPropertyDetailId) {
        this.productDetailPropertyDetailId = productDetailPropertyDetailId;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public int getPropertyDetailId() {
        return propertyDetailId;
    }

    public void setPropertyDetailId(int propertyDetailId) {
        this.propertyDetailId = propertyDetailId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
