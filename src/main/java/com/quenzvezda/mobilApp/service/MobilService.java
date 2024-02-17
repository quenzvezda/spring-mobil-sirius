package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.model.Mobil;

import java.util.List;

public interface MobilService {
    List<Mobil> findAll();
    Mobil findById(Long id);
    Mobil save(Mobil mobil);
    void deleteById(Long id);
}
