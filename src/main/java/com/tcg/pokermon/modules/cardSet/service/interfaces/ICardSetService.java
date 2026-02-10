package com.tcg.pokermon.modules.cardSet.service.interfaces;

import com.tcg.pokermon.modules.cardSet.dto.CardSetInfoDTO;

public interface ICardSetService {
    CardSetInfoDTO findSetByCode(String setCode);
}
