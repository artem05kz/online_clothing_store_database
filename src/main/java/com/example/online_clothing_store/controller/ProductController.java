package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.Product;
import com.example.online_clothing_store.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;
    private final EntityManager entityManager;

    public ProductController(ProductRepository repo, EntityManager entityManager) {
        this.repo = repo;
        this.entityManager = entityManager;
    }

    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }

    @PostMapping("/sync")
    public void sync(@RequestBody List<Product> products) {
        for (Product p : products) repo.save(p);
    }

    @GetMapping("/with-categories")
    public List<Product> getAllWithCategories() {
        return entityManager.createQuery(
                "SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category",
                Product.class
        ).getResultList();
    }

}