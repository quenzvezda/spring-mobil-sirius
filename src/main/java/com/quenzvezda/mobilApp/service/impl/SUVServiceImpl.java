package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.model.SUV;
import com.quenzvezda.mobilApp.repository.SUVRepository;
import com.quenzvezda.mobilApp.service.SUVService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SUVServiceImpl implements SUVService {
    private final SUVRepository suvRepository;

    public SUVServiceImpl(SUVRepository suvRepository) {
        this.suvRepository = suvRepository;
    }

    @Override
    public List<SUV> findAll() {
        return suvRepository.findAll();
    }

    @Override
    public SUV findById(Long id) {
        return suvRepository.findById(id).orElse(null);
    }

    @Override
    public SUV save(SUV suv) {
        return suvRepository.save(suv);
    }

    @Override
    public void deleteById(Long id) {
        suvRepository.deleteById(id);
    }
}
