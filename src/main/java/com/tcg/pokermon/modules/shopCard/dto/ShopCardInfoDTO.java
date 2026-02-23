package com.tcg.pokermon.modules.shopCard.dto;

import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.modules.shopCard.enums.CardRarityEnum;
import com.tcg.pokermon.modules.shopCard.enums.CardStageEnum;
import com.tcg.pokermon.modules.shopCard.enums.CardTypeEnum;

import java.util.List;

public record ShopCardInfoDTO(
        Long id,
        String name,
        String image,
        Double avgPrice,
        CardRarityEnum rarity,
        List<CardTypeEnum> types,
        CardStageEnum stage
) {
    public ShopCardInfoDTO(ShopCard shopCard) {
        this(shopCard.getId(),
                shopCard.getName(),
                shopCard.getImage(),
                shopCard.getAvgPrice(),
                shopCard.getRarity(),
                shopCard.getTypes(),
                shopCard.getStage());
    }
}
