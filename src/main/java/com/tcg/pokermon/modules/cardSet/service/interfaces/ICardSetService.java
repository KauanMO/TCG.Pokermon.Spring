package com.tcg.pokermon.modules.cardSet.service.interfaces;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.cardSet.dto.CreateCardSetDTO;
import com.tcg.pokermon.shared.service.ICreateService;

import java.util.Optional;

public interface ICardSetService extends ICreateService<CardSet, CreateCardSetDTO> {
    Optional<CardSet> findByExternalId(Long externalId);
}
