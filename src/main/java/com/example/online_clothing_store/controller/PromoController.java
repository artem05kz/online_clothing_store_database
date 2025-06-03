package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.Promo;
import com.example.online_clothing_store.repository.PromoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promos")
public class PromoController {
    private final PromoRepository repo;

    public PromoController(PromoRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Promo> getAll() { return repo.findAll(); }

    @GetMapping("/active")
    public Promo getActive() { return repo.findFirstByIsActiveTrue(); }

    @GetMapping("/{code}")
    public Promo getByCode(@PathVariable String code) { return repo.findByCode(code); }

    @PostMapping("/sync")
    public void sync(@RequestBody List<Promo> promos) {
        for (Promo p : promos) repo.save(p);
    }
}
