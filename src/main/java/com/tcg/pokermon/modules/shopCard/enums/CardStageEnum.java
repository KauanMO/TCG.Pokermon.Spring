package com.tcg.pokermon.modules.shopCard.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CardStageEnum {
    BASIC("Basic"),
    STAGE_1("Stage 1"),
    STAGE_2("Stage 2"),
    STAGE_3("Stage 3"),
    VMAX("VMAX"),
    VSTAR("VSTAR");

    private final String displayName;
}
