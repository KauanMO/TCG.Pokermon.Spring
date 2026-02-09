package com.tcg.pokermon.modules.user.dto;

import com.tcg.pokermon.modules.user.User;

import java.time.LocalDateTime;

public record UserInfoDTO(
        String username,
        LocalDateTime createdAt,
        Integer favoritePokemonCode
) {
    public UserInfoDTO(User u) {
        this(u.getUsername(), u.getCreatedAt(), u.getFavoritePokemonCode());
    }
}
