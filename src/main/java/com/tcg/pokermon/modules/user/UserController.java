package com.tcg.pokermon.modules.user;

import com.tcg.pokermon.modules.user.dto.CreateUserDTO;
import com.tcg.pokermon.modules.user.dto.UserInfoDTO;
import com.tcg.pokermon.modules.user.service.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("u")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserInfoDTO> register(@RequestBody @Valid CreateUserDTO dto) {
        User newUser = Objects.requireNonNull(service.create(dto));

        return ResponseEntity
                .ok()
                .body(new UserInfoDTO(newUser));
    }
}
