package com.example.online_clothing_store.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class OrderItemId implements java.io.Serializable {
    private Integer orderId;
    private Integer productId;
}