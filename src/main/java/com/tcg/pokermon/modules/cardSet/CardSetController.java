package com.tcg.pokermon.modules.cardSet;

import com.tcg.pokermon.modules.cardSet.service.interfaces.ICardSetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cs")
@RequiredArgsConstructor
public class CardSetController {
    private final ICardSetService service;


}
