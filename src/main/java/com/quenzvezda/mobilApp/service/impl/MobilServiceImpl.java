package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.model.Mobil;
import com.quenzvezda.mobilApp.repository.MobilRepository;
import com.quenzvezda.mobilApp.service.MobilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobilServiceImpl implements MobilService {
    private final MobilRepository mobilRepository;

    public MobilServiceImpl(MobilRepository mobilRepository) {
        this.mobilRepository = mobilRepository;
    }

    @Override
    public List<Mobil> findAll() {
        return mobilRepository.findAll();
    }

    @Override
    public Mobil findById(Long id) {
        return mobilRepository.findById(id).orElse(null);
    }

    @Override
    public Mobil save(Mobil mobil) {
        return mobilRepository.save(mobil);
    }

    @Override
    public void deleteById(Long id) {
        mobilRepository.deleteById(id);
    }
}
