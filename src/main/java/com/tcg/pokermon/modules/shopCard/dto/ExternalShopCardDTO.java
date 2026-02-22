package com.tcg.pokermon.modules.shopCard.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExternalShopCardDTO {
    @CsvBindByName(column = "productId")
    Long id;

    @CsvBindByName(column = "cleanName")
    String name;

    @CsvBindByName(column = "imageUrl")
    String image;

    @CsvBindByName(column = "groupId")
    Long externalCardSetId;

    @CsvBindByName(column = "marketPrice")
    Double avgPrice;

    @CsvBindByName(column = "midPrice")
    Double midPrice;

    @CsvBindByName(column = "extRarity")
    String rarity;

    @CsvBindByName(column = "extCardType")
    String type;

    @CsvBindByName(column = "extStage")
    String stage;
}
