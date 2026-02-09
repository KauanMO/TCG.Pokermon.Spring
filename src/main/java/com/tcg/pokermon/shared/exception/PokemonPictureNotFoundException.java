package com.tcg.pokermon.shared.exception;

public class PokemonPictureNotFoundException extends RuntimeException {
    public PokemonPictureNotFoundException(Integer pokemonCode) {
        super("Pokemon not found with the code: " + pokemonCode);
    }
}
