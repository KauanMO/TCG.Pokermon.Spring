package com.tcg.pokermon.modules.auth.service.interfaces;

import com.tcg.pokermon.modules.auth.dto.LoginDTO;
import com.tcg.pokermon.modules.auth.dto.LoginInfoDTO;
import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.dto.CreateUserDTO;

public interface IAuthService {
    LoginInfoDTO login(LoginDTO dto);

    User register(CreateUserDTO dto);

    Long getUserId();
}
