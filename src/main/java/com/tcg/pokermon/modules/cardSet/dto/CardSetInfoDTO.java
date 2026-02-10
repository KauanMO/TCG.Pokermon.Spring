package com.tcg.pokermon.modules.cardSet.dto;

import com.tcg.pokermon.modules.card.dto.CardSimpleInfoDTO;

import java.util.List;

public record CardSetInfoDTO(
        String id,
        String logo,
        String name,
        String releaseDate,
        String symbol,
        CardCount cardCount,
        Serie serie,
        List<CardSimpleInfoDTO> cards
) {
    public record CardCount(
            Integer firstEd,
            Integer holo,
            Integer normal,
            Integer official,
            Integer reverse,
            Integer total
    ) {
    }

    public record Serie(
            String id,
            String name
    ) {
    }
}
