package com.tcg.pokermon.modules.cardSet;

import com.tcg.pokermon.modules.shopCard.ShopCard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pkm_card_set")
public class CardSet {
    @Id
    private Long id;

    private String name;

    private String logo;

    private Double price;

    private String firstCardImage;

    private String secondCardImage;

    private String thirdCardImage;

    @OneToMany
    private List<ShopCard> shopCards;
}
