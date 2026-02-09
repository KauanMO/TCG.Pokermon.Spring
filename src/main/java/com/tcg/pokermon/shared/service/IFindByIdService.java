package com.tcg.pokermon.shared.service;

public interface IFindByIdService<T> {
    T findById(Long id);
}
