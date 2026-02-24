package com.tcg.pokermon.modules.card.service.interfaces;

import com.tcg.pokermon.modules.card.Card;
import com.tcg.pokermon.modules.card.dto.CardInfoDTO;
import com.tcg.pokermon.modules.card.dto.CardPageDTO;
import com.tcg.pokermon.modules.card.dto.CreateCardDTO;
import com.tcg.pokermon.shared.service.ICreateService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICardService extends ICreateService<Card, CreateCardDTO> {
    List<CardInfoDTO> buyCardSet(Long id, Long userId);

    CardPageDTO findPageByUserId(Long userId, Pageable pageable);
}
