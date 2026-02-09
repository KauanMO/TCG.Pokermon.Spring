package com.tcg.pokermon.modules.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(
        @NotNull(message = "Username field is required")
        @NotBlank(message = "Username field can not be blank")
        String username,

        @NotNull(message = "Password field is required")
        @NotBlank(message = "Password field can not be blank")
        @Size(min = 6, message = "Password field needs to have more than 6 characteres")
        String password
) {
}
