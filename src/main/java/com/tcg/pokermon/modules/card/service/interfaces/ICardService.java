package com.tcg.pokermon.modules.card.service.interfaces;

import com.tcg.pokermon.modules.card.Card;
import com.tcg.pokermon.modules.card.dto.CardInfoDTO;
import com.tcg.pokermon.modules.card.dto.CreateCardDTO;
import com.tcg.pokermon.shared.service.ICreateService;

import java.util.List;

public interface ICardService extends ICreateService<Card, CreateCardDTO> {
    List<CardInfoDTO> buyCardSet(Long id, Long userId);
}
