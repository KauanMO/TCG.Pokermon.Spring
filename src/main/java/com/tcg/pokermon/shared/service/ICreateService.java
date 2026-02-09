package com.tcg.pokermon.shared.service;

public interface ICreateService<T, DTO> {
    T create(DTO dto);
}
