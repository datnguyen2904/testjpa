package com.example.jpatest.service;

import com.example.jpatest.models.ProductDetailPropertyDetails;
import com.example.jpatest.models.ProductDetails;
import com.example.jpatest.models.responobject.Respon;

import java.util.List;

public interface IProductDetails {
    public List<ProductDetails> ShowProductDetails();
    public Respon<ProductDetails> order(String name, int quantity);
    public Respon<ProductDetails> addQuantity(String name, int quantity);
    public List<ProductDetails> ShowAllProductDetails();


}
