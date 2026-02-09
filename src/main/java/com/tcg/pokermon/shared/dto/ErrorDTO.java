package com.tcg.pokermon.shared.dto;

import java.time.LocalDateTime;

public record ErrorDTO(
        LocalDateTime timestamp,
        Object message
) {
    public ErrorDTO(Object message) {
        this(LocalDateTime.now(), message);
    }
}
