package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.Category;
import com.example.online_clothing_store.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Category> getAll() { return repo.findAll(); }

    @PostMapping("/sync")
    public void sync(@RequestBody List<Category> categories) {
        for (Category c : categories) repo.save(c);
    }
}
