package com.tcg.pokermon.modules.cardSet.service;

import com.tcg.pokermon.modules.card.dto.CardSimpleInfoDTO;
import com.tcg.pokermon.modules.cardSet.dto.CardSetInfoDTO;
import com.tcg.pokermon.modules.cardSet.service.interfaces.ICardSetService;
import lombok.RequiredArgsConstructor;
import net.tcgdex.sdk.models.Set;
import org.springframework.stereotype.Service;
import net.tcgdex.sdk.TCGdex;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CardSetService implements ICardSetService {
    private final TCGdex dex;

    @Override
    public CardSetInfoDTO findSetByCode(String setCode) {
        Set cardSet = dex.fetchSet(setCode);

        if (cardSet == null) return null;

        return new CardSetInfoDTO(cardSet.getId(), cardSet.getLogo(),
                cardSet.getName(),
                cardSet.getReleaseDate(),
                cardSet.getSymbol(),
                new CardSetInfoDTO.CardCount(cardSet.getCardCount().getFirstEd(),
                        cardSet.getCardCount().getHolo(),
                        cardSet.getCardCount().getNormal(),
                        cardSet.getCardCount().getOfficial(),
                        cardSet.getCardCount().getReverse(),
                        cardSet.getCardCount().getTotal()),
                new CardSetInfoDTO.Serie(cardSet.getSerie().getId(), cardSet.getSerie().getName()),
                cardSet.getCards()
                        .stream()
                        .map(c -> new CardSimpleInfoDTO(c.getId(),
                                c.getImage(),
                                c.getLocalId(),
                                c.getName()))
                        .toList()
        );
    }
}
