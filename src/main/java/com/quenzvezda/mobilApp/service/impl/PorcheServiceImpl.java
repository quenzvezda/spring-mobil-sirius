package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.model.Porche;
import com.quenzvezda.mobilApp.repository.PorcheRepository;
import com.quenzvezda.mobilApp.service.PorcheService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorcheServiceImpl implements PorcheService {
    private final PorcheRepository porcheRepository;

    public PorcheServiceImpl(PorcheRepository porcheRepository) {
        this.porcheRepository = porcheRepository;
    }

    @Override
    public List<Porche> findAll() {
        return porcheRepository.findAll();
    }

    @Override
    public Porche findById(Long id) {
        return porcheRepository.findById(id).orElse(null);
    }

    @Override
    public Porche save(Porche porche) {
        return porcheRepository.save(porche);
    }

    @Override
    public void deleteById(Long id) {
        porcheRepository.deleteById(id);
    }
}
