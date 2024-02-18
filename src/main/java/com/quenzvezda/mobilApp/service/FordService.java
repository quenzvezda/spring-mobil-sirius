package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.model.Ford;

import java.util.List;

public interface FordService {
    List<Ford> findAll();
    Ford findById(Long id);
    Ford save(Ford ford);
    void deleteById(Long id);
}
