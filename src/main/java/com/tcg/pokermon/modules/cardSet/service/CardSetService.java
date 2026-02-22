package com.tcg.pokermon.modules.cardSet.service;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.cardSet.CardSetRepository;
import com.tcg.pokermon.modules.cardSet.dto.CreateCardSetDTO;
import com.tcg.pokermon.modules.cardSet.service.interfaces.ICardSetService;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.shared.enums.ResourceEnum;
import com.tcg.pokermon.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardSetService implements ICardSetService {
    private final CardSetRepository repository;

    @Override
    public Optional<CardSet> findByExternalId(Long externalId) {
        return repository.findById(externalId);
    }

    @Override
    public void updateCardSetPrice(Long id, Double price) {
        var cardSet = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ResourceEnum.CARDSET, id));

        cardSet.setPrice(price);
        repository.save(cardSet);
    }

    @Override
    public void primaryUpdateCardSet(Long id, List<ShopCard> cards) {
        var cardSet = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ResourceEnum.CARDSET, id));

        List<ShopCard> topCards = cards.stream()
                .sorted(Comparator.comparing(ShopCard::getAvgPrice).reversed())
                .limit(3)
                .toList();

        Double totalTopCardsPrice = 0.0;

        for (ShopCard card : topCards) {
            totalTopCardsPrice += card.getAvgPrice();
        }

        cardSet.setPrice((double) Math.round(totalTopCardsPrice / topCards.size()));
        cardSet.setFirstCardImage(topCards.getFirst().getImage());
        cardSet.setSecondCardImage(topCards.get(1).getImage());
        cardSet.setThirdCardImage(topCards.getLast().getImage());

        repository.save(cardSet);
    }

    @Override
    public CardSet create(CreateCardSetDTO dto) {
        CardSet newCardSet = CardSet.builder()
                .id(dto.externalId())
                .name(dto.name())
                .price(0.0)
                .logo(null)
                .build();

        return repository.save(newCardSet);
    }
}
