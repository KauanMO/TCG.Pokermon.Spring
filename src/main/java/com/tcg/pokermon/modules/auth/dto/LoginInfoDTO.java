package com.tcg.pokermon.modules.auth.dto;

import com.tcg.pokermon.modules.user.dto.UserInfoDTO;

public record LoginInfoDTO(
        UserInfoDTO user,
        String token
) {
}
