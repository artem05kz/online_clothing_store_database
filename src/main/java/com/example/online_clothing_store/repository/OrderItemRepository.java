package com.example.online_clothing_store.repository;

import com.example.online_clothing_store.model.OrderItem;
import com.example.online_clothing_store.model.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
    List<OrderItem> findByOrderId(Integer orderId);
}
