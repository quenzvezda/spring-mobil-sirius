package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.model.Sedan;

import java.util.List;

public interface SedanService {
    List<Sedan> findAll();
    Sedan findById(Long id);
    Sedan save(Sedan sedan);
    void deleyeById(Long id);
}
