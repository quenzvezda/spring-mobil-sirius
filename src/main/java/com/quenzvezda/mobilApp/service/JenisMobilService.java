package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.model.JenisMobil;

import java.util.List;

public interface JenisMobilService {
    List<JenisMobil> findAll();
    JenisMobil findById(Long id);
    JenisMobil save(JenisMobil jenisMobil);
    void deleteById(Long id);
}
