package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.Order;
import com.example.online_clothing_store.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository repo;

    public OrderController(OrderRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Order> getAll() { return repo.findAll(); }

    @GetMapping(params = "user_id")
    public List<Order> getByUser(@RequestParam("user_id") Integer userId) {
        return repo.findByUserId(userId);
    }

    @PostMapping("/sync")
    public void sync(@RequestBody List<Order> orders) {
        for (Order o : orders) {
            if (o.getId() == null) {
                // Новый заказ — создаём
                repo.save(o);
            } else {
                // Существующий заказ — обновляем
                repo.save(o);
            }
        }
    }
}