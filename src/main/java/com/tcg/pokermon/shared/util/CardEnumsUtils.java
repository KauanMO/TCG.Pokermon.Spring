package com.tcg.pokermon.shared.util;

import com.tcg.pokermon.modules.cardSet.enums.CardRarityEnum;
import com.tcg.pokermon.modules.cardSet.enums.CardStageEnum;

public class CardEnumsUtils {
    public static CardRarityEnum getRarityByDisplayName(String displayName) {
        String normalized = displayName.trim();

        for (CardRarityEnum r : CardRarityEnum.values()) {
            if (r.getDisplayName().equalsIgnoreCase(normalized)) {
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
