package com.tcg.pokermon.modules.user.service.interfaces;

import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.dto.CreateUserDTO;
import com.tcg.pokermon.shared.service.ICreateService;

public interface IUserService extends ICreateService<User, CreateUserDTO> {

}
