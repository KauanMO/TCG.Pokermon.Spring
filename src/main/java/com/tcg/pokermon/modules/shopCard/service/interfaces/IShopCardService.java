package com.tcg.pokermon.modules.shopCard.service.interfaces;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.modules.shopCard.dto.ExternalShopCardDTO;
import com.tcg.pokermon.shared.service.IFindByIdService;

import java.util.List;

public interface IShopCardService extends IFindByIdService<ShopCard> {
    List<ShopCard> createAll(List<ExternalShopCardDTO> dtos, CardSet cardSet);

    List<ShopCard> findByCardSetId(Long cardSetId);
}
