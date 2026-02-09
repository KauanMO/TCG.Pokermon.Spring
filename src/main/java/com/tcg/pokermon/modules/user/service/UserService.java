package com.tcg.pokermon.modules.user.service;

import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.UserRepository;
import com.tcg.pokermon.modules.user.dto.CreateUserDTO;
import com.tcg.pokermon.modules.user.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository repository;

    @Override
    public User create(CreateUserDTO createUserDTO) {
        User newUser = User.builder()
                .password(createUserDTO.password())
                .username(createUserDTO.username())
                .build();

        return repository.save(newUser);
    }
}
