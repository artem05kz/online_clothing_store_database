package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.Product;
import com.example.online_clothing_store.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;

    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Product> getAll() { return repo.findAll(); }

    @PostMapping("/sync")
    public void sync(@RequestBody List<Product> products) {
        for (Product p : products) repo.save(p);
    }
}
