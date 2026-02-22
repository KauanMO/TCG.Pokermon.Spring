package com.tcg.pokermon.modules.cardSet.service;

import com.tcg.pokermon.modules.cardSet.CardSet;
import com.tcg.pokermon.modules.cardSet.CardSetRepository;
import com.tcg.pokermon.modules.cardSet.dto.CreateCardSetDTO;
import com.tcg.pokermon.modules.cardSet.service.interfaces.ICardSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardSetService implements ICardSetService {
    private final CardSetRepository repository;

    @Override
    public Optional<CardSet> findByExternalId(Long externalId) {
        return repository.findByExternalId(externalId);
    }

    @Override
    public CardSet create(CreateCardSetDTO dto) {
        CardSet newCardSet = CardSet.builder()
                .name(dto.name())
                .price(0.0)
                .logo(null)
                .externalId(dto.externalId())
                .build();

        return repository.save(newCardSet);
    }
}
