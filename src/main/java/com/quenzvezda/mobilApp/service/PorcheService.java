package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.PorcheDto;
import com.quenzvezda.mobilApp.model.Porche;

import java.util.List;

public interface PorcheService {
    List<PorcheDto> findAll();
    PorcheDto findById(Long mobilId);
    PorcheDto save(PorcheDto porscheDTO);
    void deleteById(Long mobilId);
}
