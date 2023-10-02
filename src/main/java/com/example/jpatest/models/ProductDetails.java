package com.example.jpatest.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private int productDetailId;
    @Column(name = "productpropertyname")
    private String productPropertyName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;
    @Column(name = "shellprice")
    private float shellPrice;
    @Column(name = "parentid", insertable=false, updatable=false)
    private Integer parentId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetails")
    @JsonManagedReference
    private List<ProductDetailPropertyDetails> productDetailPropertyDetails;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parentid")
    private ProductDetails parent;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private List<ProductDetails> children;

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getProductPropertyName() {
        return productPropertyName;
    }

    public void setProductPropertyName(String productPropertyName) {
        this.productPropertyName = productPropertyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getShellPrice() {
        return shellPrice;
    }

    public void setShellPrice(float shellPrice) {
        this.shellPrice = shellPrice;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<ProductDetailPropertyDetails> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(List<ProductDetailPropertyDetails> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }

    public ProductDetails getParent() {
        return parent;
    }

    public void setParent(ProductDetails parent) {
        this.parent = parent;
    }

    public List<ProductDetails> getChildren() {
        return children;
    }

    public void setChildren(List<ProductDetails> children) {
        this.children = children;
    }
}
