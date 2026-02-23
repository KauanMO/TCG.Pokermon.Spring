package com.tcg.pokermon.modules.card.dto;

import com.tcg.pokermon.modules.card.Card;
import com.tcg.pokermon.modules.shopCard.dto.ShopCardInfoDTO;

public record CardInfoDTO(
        Long id,
        Double quality,
        Integer betCount,
        Double price,
        ShopCardInfoDTO shopCard
) {
    public CardInfoDTO(Card card) {
        this(card.getId(),
                card.getQuality(),
                card.getBetCount(),
                card.getPrice(),
                new ShopCardInfoDTO(card.getShopCard()));
    }
}
