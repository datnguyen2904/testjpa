package com.example.jpatest.repository.dbcontext;

import com.example.jpatest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dbcontext {
    @Autowired
    public ProductDetailPropertyDetailsRepo productDetailPropertyDetailsRepo;
    @Autowired
    public ProductDetailsRepo productDetailsRepo;
    @Autowired
    public ProductsRepo productsRepo;
    @Autowired
    public PropertiesRepo propertiesRepo;
    @Autowired
    public PropertyDetailsRepo propertyDetailsRepo;
}
