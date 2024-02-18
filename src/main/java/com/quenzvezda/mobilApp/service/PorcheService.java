package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.model.Porche;

import java.util.List;

public interface PorcheService {
    List<Porche> findAll();
    Porche findById(Long id);
    Porche save(Porche porche);
    void deleteById(Long id);
}
