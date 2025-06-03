package com.example.online_clothing_store.repository;

import com.example.online_clothing_store.model.Favorite;
import com.example.online_clothing_store.model.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
    List<Favorite> findByUserId(Integer userId);
}
