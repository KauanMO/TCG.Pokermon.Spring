package com.tcg.pokermon.shared.config;

import net.tcgdex.sdk.TCGdex;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LibConfig {
    @Bean
    public TCGdex tcgdex() {
        return new TCGdex("en");
    }
}
