package com.example.jpatest.repository;

import com.example.jpatest.models.ProductDetailPropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailPropertyDetailsRepo extends JpaRepository<ProductDetailPropertyDetails, Integer> {
}
