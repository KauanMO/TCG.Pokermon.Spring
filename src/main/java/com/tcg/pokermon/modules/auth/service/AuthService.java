package com.tcg.pokermon.modules.auth.service;

import com.tcg.pokermon.modules.auth.service.interfaces.IAuthService;
import com.tcg.pokermon.modules.auth.dto.LoginDTO;
import com.tcg.pokermon.modules.auth.dto.LoginInfoDTO;
import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.dto.CreateUserDTO;
import com.tcg.pokermon.modules.user.dto.UserInfoDTO;
import com.tcg.pokermon.modules.user.service.interfaces.IUserService;
import com.tcg.pokermon.shared.exception.SecurityErrorException;
import com.tcg.pokermon.shared.security.JwtService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final IUserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public LoginInfoDTO login(LoginDTO dto) {
        User user = userService.findUserByUsername(dto.username());

        if (user == null) {
            throw new BadCredentialsException("Bad credentials");
        }

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }

        String token = jwtService.generateToken(user);

        return new LoginInfoDTO(new UserInfoDTO(user), token);
    }

    @Override
    public User register(CreateUserDTO dto) {
        return userService.create(dto);
    }

    @Override
    public Long getUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null) throw new SecurityErrorException();

        Claims claims = (Claims) auth.getDetails();

        if (claims == null) throw new SecurityErrorException();

        return claims.get("id", Long.class);
    }
}
