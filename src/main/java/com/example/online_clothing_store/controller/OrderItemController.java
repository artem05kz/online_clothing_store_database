package com.example.online_clothing_store.controller;

import com.example.online_clothing_store.model.OrderItem;
import com.example.online_clothing_store.repository.OrderItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order_items")
public class OrderItemController {
    private final OrderItemRepository repo;

    public OrderItemController(OrderItemRepository repo) { this.repo = repo; }

    @GetMapping
    public List<OrderItem> getAll() { return repo.findAll(); }

    @GetMapping(params = "order_id")
    public List<OrderItem> getByOrder(@RequestParam("order_id") Integer orderId) {
        return repo.findByOrderId(orderId);
    }

    @PostMapping("/sync")
    public void sync(@RequestBody List<OrderItem> items) {
        for (OrderItem i : items) repo.save(i);
    }
}
