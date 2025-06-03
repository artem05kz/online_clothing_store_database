package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.ProductImage;
import com.example.online_clothing_store.repository.ProductImageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product_images")
public class ProductImageController {
    private final ProductImageRepository repo;

    public ProductImageController(ProductImageRepository repo) { this.repo = repo; }

    @GetMapping
    public List<ProductImage> getAll() { return repo.findAll(); }

    @PostMapping("/sync")
    public void sync(@RequestBody List<ProductImage> images) {
        for (ProductImage img : images) repo.save(img);
    }
}
