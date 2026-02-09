package com.tcg.pokermon.modules.user;

import com.tcg.pokermon.modules.auth.service.interfaces.IAuthService;
import com.tcg.pokermon.modules.user.dto.*;
import com.tcg.pokermon.modules.user.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("u")
@RequiredArgsConstructor
public class UserController {
    private final IUserService service;
    private final IAuthService authService;

    @PatchMapping
    public ResponseEntity<UserInfoDTO> patchUserInfo(@RequestBody PatchUserDTO dto) {
        service.patch(authService.getUserId(), dto);

        return ResponseEntity
                .ok()
                .build();
    }
}
