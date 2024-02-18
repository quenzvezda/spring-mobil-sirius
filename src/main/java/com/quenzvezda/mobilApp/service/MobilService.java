package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.MobilDto;
import com.quenzvezda.mobilApp.model.Mobil;

import java.util.List;

public interface MobilService {
    List<MobilDto> findAll();
    MobilDto findById(Long id);
    MobilDto save(MobilDto mobilDto);
    void deleteById(Long id);
}
