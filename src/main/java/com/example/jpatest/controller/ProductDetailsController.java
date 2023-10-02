package com.example.jpatest.controller;

import com.example.jpatest.models.ProductDetailPropertyDetails;
import com.example.jpatest.models.ProductDetails;
import com.example.jpatest.models.responobject.Respon;
import com.example.jpatest.service.ProductDetailsService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductDetailsController {
    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping(value = "showproductdetails")
    public List<ProductDetails> ShowProductDetails() {
        return productDetailsService.ShowProductDetails();
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public Respon<ProductDetails> Order(@RequestParam String name, @RequestParam int quantity) {
        return productDetailsService.order(name, quantity);
    }

    @RequestMapping(value = "capnhatsoluong", method = RequestMethod.PUT)
    public Respon<ProductDetails> AddQuantity(@RequestParam String name, @RequestParam int quantity) {
        return productDetailsService.addQuantity(name, quantity);
    }

    @RequestMapping(value = "showallproductdetails", method = RequestMethod.GET)
    public List<ProductDetails> ShowAllProductDetails() {
        return productDetailsService.ShowAllProductDetails();
    }

}
