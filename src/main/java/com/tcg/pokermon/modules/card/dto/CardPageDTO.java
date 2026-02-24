package com.tcg.pokermon.modules.card.dto;

import java.util.List;

public record CardPageDTO(
        Integer totalPages,
        Long totalElements,
        Integer page,
        Integer size,
        List<CardInfoDTO> cards
) {
}
