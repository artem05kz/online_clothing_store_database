package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.Favorite;
import com.example.online_clothing_store.repository.FavoriteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    private final FavoriteRepository repo;

    public FavoriteController(FavoriteRepository repo) { this.repo = repo; }

    @GetMapping(params = "user_id")
    public List<Favorite> getByUser(@RequestParam("user_id") Integer userId) {
        return repo.findByUserId(userId);
    }

    @PostMapping("/sync")
    public void sync(@RequestBody List<Favorite> favorites) {
        for (Favorite f : favorites) repo.save(f);
    }
}
