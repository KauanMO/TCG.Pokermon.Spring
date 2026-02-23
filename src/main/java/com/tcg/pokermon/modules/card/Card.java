package com.tcg.pokermon.modules.card;

import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.modules.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pkm_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double quality;

    private Integer betCount;

    private Double price = 0.0;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private ShopCard shopCard;

    @PreUpdate
    @PrePersist
    public void calculatePrice() {
        if (shopCard != null && shopCard.getAvgPrice() != null && quality != null) {
            this.price = (shopCard.getAvgPrice() * 2) * quality;
        }
    }
}
