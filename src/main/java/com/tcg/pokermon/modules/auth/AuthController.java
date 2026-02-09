package com.tcg.pokermon.modules.auth;

import com.tcg.pokermon.modules.auth.service.interfaces.IAuthService;
import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.dto.CreateUserDTO;
import com.tcg.pokermon.modules.auth.dto.LoginDTO;
import com.tcg.pokermon.modules.auth.dto.LoginInfoDTO;
import com.tcg.pokermon.modules.user.dto.UserInfoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final IAuthService service;

    @PostMapping
    public ResponseEntity<UserInfoDTO> register(@RequestBody @Valid CreateUserDTO dto) {
        User newUser = Objects.requireNonNull(service.register(dto));

        return ResponseEntity
                .ok()
                .body(new UserInfoDTO(newUser));
    }

    @PostMapping("login")
    public ResponseEntity<LoginInfoDTO> login(@RequestBody @Valid LoginDTO dto) {
        LoginInfoDTO loginInfo = service.login(dto);

        return ResponseEntity
                .ok(loginInfo);
    }
}
