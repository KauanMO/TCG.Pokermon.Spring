package com.tcg.pokermon.shared.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PokemonPicturesRestClient {
    private final RestClient restClient;

    public PokemonPicturesRestClient(@Value("${external.pokemon-pictures-url}") String pokemonPicturesUrl) {
        this.restClient = RestClient
                .builder()
                .baseUrl(pokemonPicturesUrl)
                .build();
    }

    public Boolean checkPokemonPicture(Integer pokemonCode) {
        String formattedPokemonCode = String.format("%03d", pokemonCode);

        ResponseEntity<Void> response = this.restClient
                .get()
                .uri("/{formattedPokemonCode}.png?raw=true", formattedPokemonCode)
                .retrieve()
                .toBodilessEntity();

        System.out.println(response);

        return !response.getStatusCode().isError();
    }
}
