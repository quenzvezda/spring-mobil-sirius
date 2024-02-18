package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.dto.SedanDto;
import com.quenzvezda.mobilApp.model.Sedan;

import java.util.List;

public interface SedanService {
    List<SedanDto> findAll();
    SedanDto findById(Long mobilId);
    SedanDto save(SedanDto sedanDTO);
    void deleteById(Long mobilId);
}
