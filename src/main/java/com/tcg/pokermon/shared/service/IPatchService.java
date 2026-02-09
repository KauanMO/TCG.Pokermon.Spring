package com.tcg.pokermon.shared.service;

public interface IPatchService<DTO> {
    void patch(Long id, DTO dto);
}
