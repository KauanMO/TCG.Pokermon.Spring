package com.tcg.pokermon.modules.shopCard.service.interfaces;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.modules.shopCard.dto.ExternalShopCardDTO;

import java.util.List;

public interface IShopCardService {
    List<ShopCard> createAll(List<ExternalShopCardDTO> dtos, CardSet cardSet);
}
