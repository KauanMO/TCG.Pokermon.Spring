package com.tcg.pokermon.modules.card;

import com.tcg.pokermon.modules.auth.service.interfaces.IAuthService;
import com.tcg.pokermon.modules.card.dto.CardInfoDTO;
import com.tcg.pokermon.modules.card.service.interfaces.ICardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("c")
@RequiredArgsConstructor
public class CardController {
    private final ICardService cardService;
    private final IAuthService authService;

    @PostMapping("shop/cardset/{cardSetId}")
    public ResponseEntity<List<CardInfoDTO>> buyCardSet(@PathVariable("cardSetId") Long cardSetId) {
        List<CardInfoDTO> cards = cardService.buyCardSet(cardSetId, authService.getUserId());

        return ResponseEntity
                .ok(cards);
    }
}
