package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.Cart;
import com.example.online_clothing_store.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartRepository repo;

    public CartController(CartRepository repo) { this.repo = repo; }

    @GetMapping(params = "user_id")
    public List<Cart> getByUser(@RequestParam("user_id") Integer userId) {
        return repo.findByUserId(userId);
    }

    @PostMapping("/sync")
    public void sync(@RequestBody List<Cart> items) {
        for (Cart c : items) repo.save(c);
    }
}
