package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.model.Ford;
import com.quenzvezda.mobilApp.repository.FordRepository;
import com.quenzvezda.mobilApp.service.FordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FordServiceImpl implements FordService {
    private final FordRepository fordRepository;

    public FordServiceImpl(FordRepository fordRepository) {
        this.fordRepository = fordRepository;
    }

    @Override
    public List<Ford> findAll() {
        return fordRepository.findAll();
    }

    @Override
    public Ford findById(Long id) {
        return fordRepository.findById(id).orElse(null);
    }

    @Override
    public Ford save(Ford ford) {
        return fordRepository.save(ford);
    }

    @Override
    public void deleteById(Long id) {
        fordRepository.deleteById(id);
    }
}
