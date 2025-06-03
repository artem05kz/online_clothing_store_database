package com.example.online_clothing_store.repository;

import com.example.online_clothing_store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}
