package com.tcg.pokermon.modules.cardSet.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardRarityEnum {
    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    HOLO_RARE("Holo Rare"),
    ULTRA_RARE("Ultra Rare"),
    SECRET_RARE("Secret Rare"),
    RADIANT_RARE("Radiant Rare");

    private final String displayName;
}
