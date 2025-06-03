package com.example.online_clothing_store.repository;

import com.example.online_clothing_store.model.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoRepository extends JpaRepository<Promo, Integer> {
    Promo findByCode(String code);
    Promo findFirstByIsActiveTrue();
}
