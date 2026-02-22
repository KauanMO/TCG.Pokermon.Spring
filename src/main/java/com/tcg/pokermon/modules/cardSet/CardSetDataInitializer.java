package com.tcg.pokermon.modules.cardSet;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.tcg.pokermon.modules.shopCard.ShopCard;
import com.tcg.pokermon.modules.shopCard.dto.ExternalShopCardDTO;
import com.tcg.pokermon.modules.cardSet.dto.CreateCardSetDTO;
import com.tcg.pokermon.modules.cardSet.service.interfaces.ICardSetService;
import com.tcg.pokermon.modules.shopCard.service.interfaces.IShopCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CardSetDataInitializer implements CommandLineRunner {
    private final ICardSetService cardSetService;
    private final IShopCardService shopCardService;

    @Override
    public void run(String... args) throws IOException {
        var resolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = resolver.getResources("classpath:cardsets/*");

        for (Resource resource : resources) {
            String cardSetName = extractCardSetName(resource);

            List<ExternalShopCardDTO> externalCards = extractCards(resource);

            Long externalCardSetId = externalCards.getFirst().getExternalCardSetId();

            if (cardSetService.findByExternalId(externalCardSetId).isEmpty()) {
                CardSet newCardSet = cardSetService.create(new CreateCardSetDTO(cardSetName, externalCardSetId));

                List<ShopCard> shopCards = shopCardService.createAll(externalCards, newCardSet);

                cardSetService.primaryUpdateCardSet(externalCardSetId, shopCards);
            }
        }
    }

    private List<ExternalShopCardDTO> extractCards(Resource resource) throws IOException {
        try (var reader = new InputStreamReader(resource.getInputStream())) {
            CsvToBean<ExternalShopCardDTO> csvToBean = new CsvToBeanBuilder<ExternalShopCardDTO>(reader)
                    .withType(ExternalShopCardDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        }
    }

    private String extractCardSetName(Resource resource) {
        return Objects.requireNonNull(resource
                        .getFilename())
                .replace(".csv", "")
                .replace("_", " ")
                .replace("--", ":");
    }
}
