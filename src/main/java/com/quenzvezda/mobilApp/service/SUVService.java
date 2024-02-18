package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.model.SUV;

import java.util.List;

public interface SUVService {
    List<SUV> findAll();
    SUV findById(Long id);
    SUV save(SUV suv);
    void deleteById(Long id);
}
