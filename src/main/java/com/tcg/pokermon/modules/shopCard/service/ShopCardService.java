package com.tcg.pokermon.modules.shopCard.service;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.shopCard.enums.CardTypeEnum;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.modules.shopCard.ShopCardRepository;
import com.tcg.pokermon.modules.shopCard.dto.ExternalShopCardDTO;
import com.tcg.pokermon.modules.shopCard.service.interfaces.IShopCardService;
import com.tcg.pokermon.shared.enums.ResourceEnum;
import com.tcg.pokermon.shared.exception.ResourceNotFoundException;
import com.tcg.pokermon.shared.util.CardEnumsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopCardService implements IShopCardService {
    private final ShopCardRepository repository;

    @Override
    public List<ShopCard> createAll(List<ExternalShopCardDTO> dtos, CardSet cardSet) {
        List<ShopCard> newShopCards = new ArrayList<>();

        for (ExternalShopCardDTO dto : dtos) {
            if (!isExternalCardValid(dto)) continue;

            List<CardTypeEnum> cardTypes = new ArrayList<>();

            for (String cardType : dto.getType().split(" "))
                cardTypes.add(CardTypeEnum.valueOf(cardType.toUpperCase()));

            newShopCards.add(
                    ShopCard.builder()
                            .id(dto.getId())
                            .image(dto.getImage().replace("200w", "in_1000x1000"))
                            .name(dto.getName())
                            .types(cardTypes)
                            .rarity(CardEnumsUtils.getRarityByDisplayName(dto.getRarity()))
                            .stage(CardEnumsUtils.getStageByDisplayName(dto.getStage()))
                            .avgPrice(dto.getAvgPrice() == null ? dto.getMidPrice() : dto.getAvgPrice())
                            .cardset(cardSet)
                            .build()
            );
        }

        return repository.saveAll(newShopCards);
    }

    @Override
    public List<ShopCard> findByCardSetId(Long cardSetId) {
        return repository.findByCardsetId(cardSetId);
    }

    @Override
    public ShopCard findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ResourceEnum.SHOPCARD, id));
    }

    private Boolean isExternalCardValid(ExternalShopCardDTO dto) {
        return repository.findById(dto.getId()).isEmpty()
                && dto.getType() != null
                && !dto.getType().isEmpty()
                && !dto.getType().contains("Stadium")
                && !dto.getType().contains("Supporter")
                && !dto.getType().contains("Special")
                && !dto.getType().contains("Energy")
                && !dto.getType().contains("Item")
                && !dto.getType().contains("Trainer");
    }
}
