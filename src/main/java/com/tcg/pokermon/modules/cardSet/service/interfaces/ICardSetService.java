package com.tcg.pokermon.modules.cardSet.service.interfaces;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.cardSet.dto.CreateCardSetDTO;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.shared.service.ICreateService;
import com.tcg.pokermon.shared.service.IFindByIdService;

import java.util.List;
import java.util.Optional;

public interface ICardSetService extends ICreateService<CardSet, CreateCardSetDTO> {
    Optional<CardSet> findById(Long id);

    void primaryUpdateCardSet(Long id, List<ShopCard> cards);
}
