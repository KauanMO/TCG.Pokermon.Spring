package com.tcg.pokermon.modules.user.service.interfaces;

import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.dto.CreateUserDTO;
import com.tcg.pokermon.modules.user.dto.PatchUserDTO;
import com.tcg.pokermon.shared.service.ICreateService;
import com.tcg.pokermon.shared.service.IFindByIdService;
import com.tcg.pokermon.shared.service.IPatchService;

public interface IUserService extends ICreateService<User, CreateUserDTO>,
        IFindByIdService<User>,
        IPatchService<PatchUserDTO> {
    void updateFavoritePokemon(Long userId, Integer favoritePokemonCode);

    User findUserByUsername(String username);

    void updateBalance(Long userId, Double balance);
}
