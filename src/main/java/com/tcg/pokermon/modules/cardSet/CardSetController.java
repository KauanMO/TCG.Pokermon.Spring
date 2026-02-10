package com.tcg.pokermon.modules.cardSet;

import com.tcg.pokermon.modules.cardSet.dto.CardSetInfoDTO;
import com.tcg.pokermon.modules.cardSet.service.interfaces.ICardSetService;
import lombok.RequiredArgsConstructor;
import net.tcgdex.sdk.models.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cs")
@RequiredArgsConstructor
public class CardSetController {
    private final ICardSetService service;

    @GetMapping("{setCode}")
    public ResponseEntity<CardSetInfoDTO> getSetByCode(@PathVariable String setCode) {
        CardSetInfoDTO cardSet = service.findSetByCode(setCode);

        return ResponseEntity
                .ok(cardSet);
    }
}
