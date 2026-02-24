package com.tcg.pokermon.modules.card;

import com.tcg.pokermon.modules.auth.service.interfaces.IAuthService;
import com.tcg.pokermon.modules.card.dto.CardInfoDTO;
import com.tcg.pokermon.modules.card.dto.CardPageDTO;
import com.tcg.pokermon.modules.card.service.interfaces.ICardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("c")
@RequiredArgsConstructor
public class CardController {
    private final ICardService service;
    private final IAuthService authService;

    @PostMapping("shop/cardset/{cardSetId}")
    public ResponseEntity<List<CardInfoDTO>> buyCardSet(@PathVariable("cardSetId") Long cardSetId) {
        List<CardInfoDTO> cards = service.buyCardSet(cardSetId, authService.getUserId());

        return ResponseEntity
                .ok(cards);
    }

    @GetMapping
    public ResponseEntity<CardPageDTO> findByUserIdCardPage(
            @RequestParam(required = false) Long userId,
            Pageable pageable
    ) {
        Long finalUserId = userId != null ? userId : authService.getUserId();

        var cardPage = service.findPageByUserId(finalUserId, pageable);

        return ResponseEntity.ok(cardPage);
    }
}
