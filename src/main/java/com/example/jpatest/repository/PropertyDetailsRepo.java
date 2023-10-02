package com.example.jpatest.repository;

import com.example.jpatest.models.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepo extends JpaRepository<PropertyDetails, Integer> {
}
