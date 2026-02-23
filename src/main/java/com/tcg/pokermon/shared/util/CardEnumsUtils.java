package com.tcg.pokermon.shared.util;

import com.tcg.pokermon.modules.shopCard.enums.CardRarityEnum;
import com.tcg.pokermon.modules.shopCard.enums.CardStageEnum;

import java.util.Arrays;

public class CardEnumsUtils {
    public static CardRarityEnum getRarityByDisplayName(String displayName) {
        String normalized = displayName.trim();

        for (CardRarityEnum r : CardRarityEnum.values()) {
            if (Arrays.asList(r.getDisplayName().split("/")).contains(normalized)) {
                return r;
            }
        }

        throw new IllegalArgumentException("invalid DisplayName: " + displayName);
    }

    public static CardStageEnum getStageByDisplayName(String displayName) {
        String normalized = displayName.trim();

        for (CardStageEnum stage : CardStageEnum.values()) {
            if (stage.getDisplayName().equalsIgnoreCase(normalized)) {
                return stage;
            }
        }

        throw new IllegalArgumentException("invalid DisplayName: " + displayName);
    }
}
