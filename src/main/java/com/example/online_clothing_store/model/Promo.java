package com.example.online_clothing_store.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promos")
@Data
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imageUrl;
    private String code;
    private int discountPercent;
    private String description;
    private boolean isActive;
}
