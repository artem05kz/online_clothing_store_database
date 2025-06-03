package com.example.online_clothing_store.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    private String description;
    private String size;
    private String brand;
    private double rating;
    private String mainImageUrl;
    private String composition;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
