package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.FordDto;
import com.quenzvezda.mobilApp.model.Ford;

import java.util.List;

public interface FordService {
    List<FordDto> findAll();
    FordDto findById(Long id);
    FordDto save(FordDto fordDTO);
    void deleteById(Long id);
}
