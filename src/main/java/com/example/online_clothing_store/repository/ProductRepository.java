package com.example.online_clothing_store.repository;

import com.example.online_clothing_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
