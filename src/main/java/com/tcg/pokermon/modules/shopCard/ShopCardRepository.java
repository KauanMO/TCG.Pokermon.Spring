package com.tcg.pokermon.modules.shopCard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopCardRepository extends JpaRepository<ShopCard, Long> {
    List<ShopCard> findByCardsetId(Long cardSetId);
}
