package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.model.Sedan;
import com.quenzvezda.mobilApp.repository.SedanRepository;
import com.quenzvezda.mobilApp.service.SedanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedanServiceImpl implements SedanService {
    private final SedanRepository sedanRepository;

    public SedanServiceImpl(SedanRepository sedanRepository) {
        this.sedanRepository = sedanRepository;
    }

    @Override
    public List<Sedan> findAll() {
        return sedanRepository.findAll();
    }

    @Override
    public Sedan findById(Long id) {
        return sedanRepository.findById(id).orElse(null);
    }

    @Override
    public Sedan save(Sedan sedan) {
        return sedanRepository.save(sedan);
    }

    @Override
    public void deleyeById(Long id) {
        sedanRepository.deleteById(id);
    }
}
