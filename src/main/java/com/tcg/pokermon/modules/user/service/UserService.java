package com.tcg.pokermon.modules.user.service;

import com.tcg.pokermon.modules.auth.service.interfaces.IAuthService;
import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.UserRepository;
import com.tcg.pokermon.modules.user.dto.CreateUserDTO;
import com.tcg.pokermon.modules.user.dto.PatchUserDTO;
import com.tcg.pokermon.modules.user.service.interfaces.IUserService;
import com.tcg.pokermon.shared.client.PokemonPicturesRestClient;
import com.tcg.pokermon.shared.exception.NotAllowedException;
import com.tcg.pokermon.shared.exception.PokemonPictureNotFoundException;
import com.tcg.pokermon.shared.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository repository;
    private final PokemonPicturesRestClient pokemonPicturesRestClient;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(CreateUserDTO createUserDTO) {
        User newUser = User.builder()
                .username(createUserDTO.username())
                .password(passwordEncoder.encode(createUserDTO.password()))
                .build();

        return repository.save(newUser);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void patch(Long id, PatchUserDTO patchUserDTO) {
        if (patchUserDTO.favoritePokemonCode() != null) updateFavoritePokemon(id, patchUserDTO.favoritePokemonCode());
    }

    @Override
    public void updateFavoritePokemon(Long userId, Integer favoritePokemonCode) {
        User userFound = findById(userId);

        if (!pokemonPicturesRestClient.checkPokemonPicture(favoritePokemonCode))
            throw new PokemonPictureNotFoundException(favoritePokemonCode);

        userFound.setFavoritePokemonCode(favoritePokemonCode);

        repository.save(userFound);
    }

    @Override
    public User findUserByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }
}
