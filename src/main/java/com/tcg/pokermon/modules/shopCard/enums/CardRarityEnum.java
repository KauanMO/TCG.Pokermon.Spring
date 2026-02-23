package com.tcg.pokermon.modules.shopCard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardRarityEnum {
    COMMON("Common", 6),
    UNCOMMON("Uncommon", 5),
    RARE("Rare/Radiant Rare", 4),
    HOLO_RARE("Holo Rare", 3),
    ULTRA_RARE("Ultra Rare", 2),
    SECRET_RARE("Secret Rare", 1);

    private final String displayName;
    private final Integer weight;
}
