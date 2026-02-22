package com.tcg.pokermon.modules.cardSet.service.interfaces;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.cardSet.dto.CreateCardSetDTO;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.shared.service.ICreateService;

import java.util.List;
import java.util.Optional;

public interface ICardSetService extends ICreateService<CardSet, CreateCardSetDTO> {
    Optional<CardSet> findByExternalId(Long externalId);

    void updateCardSetPrice(Long id, Double price);

    void primaryUpdateCardSet(Long id, List<ShopCard> cards);
}
