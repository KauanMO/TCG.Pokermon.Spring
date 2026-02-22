package com.tcg.pokermon.modules.shopCard;

import com.tcg.pokermon.modules.cardSet.enums.CardRarityEnum;
import com.tcg.pokermon.modules.cardSet.enums.CardStageEnum;
import com.tcg.pokermon.modules.cardSet.enums.CardTypeEnum;
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
@Table(name = "pkm_shop_card")
public class ShopCard {
    @Id
    private Long id;

    private String name;

    private String image;

    private Double avgPrice;

    private CardRarityEnum rarity;

    private List<CardTypeEnum> types;

    private CardStageEnum stage;
}
