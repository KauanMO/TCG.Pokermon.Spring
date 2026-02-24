package com.tcg.pokermon.modules.card.service;

import com.tcg.pokermon.modules.card.Card;
import com.tcg.pokermon.modules.card.CardRepository;
import com.tcg.pokermon.modules.card.dto.CardInfoDTO;
import com.tcg.pokermon.modules.card.dto.CardPageDTO;
import com.tcg.pokermon.modules.card.dto.CreateCardDTO;
import com.tcg.pokermon.modules.card.service.interfaces.ICardService;
import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.cardSet.service.interfaces.ICardSetService;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.modules.shopCard.service.interfaces.IShopCardService;
import com.tcg.pokermon.modules.user.User;
import com.tcg.pokermon.modules.user.service.interfaces.IUserService;
import com.tcg.pokermon.shared.enums.ResourceEnum;
import com.tcg.pokermon.shared.exception.NotEnoughBalanceException;
import com.tcg.pokermon.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardService implements ICardService {
    private final CardRepository repository;
    private final IUserService userService;
    private final IShopCardService shopCardService;
    private final ICardSetService cardSetService;

    @Override
    public Card create(CreateCardDTO dto) {
        User userFound = userService.findById(dto.userId());
        ShopCard shopCardFound = shopCardService.findById(dto.shopCardId());

        Card newCard = Card.builder()
                .shopCard(shopCardFound)
                .user(userFound)
                .quality(Double.valueOf(String.format("%.6f", Math.random())))
                .betCount(0)
                .build();

        return repository.save(newCard);
    }

    @Override
    public List<CardInfoDTO> buyCardSet(Long id, Long userId) {
        CardSet cardSet = cardSetService.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ResourceEnum.CARDSET, id));

        User user = userService.findById(userId);

        if (user.getBalance() < cardSet.getPrice())
            throw new NotEnoughBalanceException(cardSet.getPrice(), user.getBalance());

        List<ShopCard> cards = shopCardService.findByCardSetId(cardSet.getId());

        List<ShopCard> drawnCards = openCardSet(cards);

        List<Card> obtainedCards = new ArrayList<>();

        for (ShopCard drawnCard : drawnCards) {
            obtainedCards.add(create(new CreateCardDTO(
                    drawnCard.getId(),
                    userId
            )));
        }

        repository.saveAll(obtainedCards);

        userService.updateBalance(user.getId(), user.getBalance() - cardSet.getPrice());

        return obtainedCards.stream()
                .sorted(Comparator.comparing((Card c) -> c.getShopCard()
                                .getRarity()
                                .getWeight())
                        .reversed())
                .map(CardInfoDTO::new)
                .toList();
    }

    @Override
    public CardPageDTO findPageByUserId(Long userId, Pageable pageable) {
        Page<Card> cardsPage = repository.findByUserId(userId, pageable);

        return new CardPageDTO(
                cardsPage.getTotalPages(),
                cardsPage.getTotalElements(),
                pageable.getPageNumber(),
                cardsPage.getContent().size(),
                cardsPage
                        .getContent().stream()
                        .map(CardInfoDTO::new)
                        .toList()
        );
    }

    private List<ShopCard> openCardSet(List<ShopCard> possibleCards) {
        List<ShopCard> cardsObtained = new ArrayList<>();

        int totalWeight = possibleCards
                .stream()
                .mapToInt(c -> c.getRarity().getWeight())
                .sum();

        int CARD_AMOUNT_PER_CARDSET = 6;

        for (int i = 0; i < CARD_AMOUNT_PER_CARDSET; i++) {
            int random = new Random().nextInt(totalWeight);

            int cumulative = 0;

            for (ShopCard card : possibleCards) {
                cumulative += card.getRarity().getWeight();

                if (random < cumulative) {
                    cardsObtained.add(card);
                    break;
                }
            }
        }

        return cardsObtained;
    }
}
