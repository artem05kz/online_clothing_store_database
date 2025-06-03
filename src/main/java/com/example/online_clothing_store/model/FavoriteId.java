package com.example.online_clothing_store.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FavoriteId implements java.io.Serializable {
    private Integer userId;
    private Integer productId;
}
