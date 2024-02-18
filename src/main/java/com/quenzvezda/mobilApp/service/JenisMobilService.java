package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.JenisMobilDto;
import com.quenzvezda.mobilApp.model.JenisMobil;

import java.util.List;

public interface JenisMobilService {
    List<JenisMobilDto> findAll();
    JenisMobilDto findById(Long id);
    JenisMobilDto save(JenisMobilDto jenisMobilDTO);
    void deleteById(Long id);
}
