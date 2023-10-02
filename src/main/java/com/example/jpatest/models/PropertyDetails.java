package com.example.jpatest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propertydetails")
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertydetailid")
    private int propertyDetailId;
    @Column(name = "propertyid", updatable = false, insertable = false)
    private int propertyId;
    @Column(name = "propertydetailcode")
    private String propertyDetailCode;
    @Column(name = "propertydetaildetail")
    private String propertyDetailDetail;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "propertyid")
    private Properties properties;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyDetails")
    @JsonManagedReference
    private List<ProductDetailPropertyDetails> productDetailPropertyDetails;

    public int getPropertyDetailId() {
        return propertyDetailId;
    }

    public void setPropertyDetailId(int propertyDetailId) {
        this.propertyDetailId = propertyDetailId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyDetailCode() {
        return propertyDetailCode;
    }

    public void setPropertyDetailCode(String propertyDetailCode) {
        this.propertyDetailCode = propertyDetailCode;
    }

    public String getPropertyDetailDetail() {
        return propertyDetailDetail;
    }

    public void setPropertyDetailDetail(String propertyDetailDetail) {
        this.propertyDetailDetail = propertyDetailDetail;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<ProductDetailPropertyDetails> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(List<ProductDetailPropertyDetails> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }
}
