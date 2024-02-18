package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.SUVDto;
import com.quenzvezda.mobilApp.model.SUV;

import java.util.List;

public interface SUVService {
    List<SUVDto> findAll();
    SUVDto findById(Long mobilId);
    SUVDto save(SUVDto suvDTO);
    void deleteById(Long mobilId);
}
