package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.model.JenisMobil;
import com.quenzvezda.mobilApp.repository.JenisMobilRepository;
import com.quenzvezda.mobilApp.service.JenisMobilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JenisMobilImpl implements JenisMobilService {
    private final JenisMobilRepository jenisMobilRepository;

    public JenisMobilImpl(JenisMobilRepository jenisMobilRepository) {
        this.jenisMobilRepository = jenisMobilRepository;
    }

    @Override
    public List<JenisMobil> findAll() {
        return jenisMobilRepository.findAll();
    }

    @Override
    public JenisMobil findById(Long id) {
        return jenisMobilRepository.findById(id).orElse(null);
    }

    @Override
    public JenisMobil save(JenisMobil jenisMobil) {
        return jenisMobilRepository.save(jenisMobil);
    }

    @Override
    public void deleteById(Long id) {
        jenisMobilRepository.deleteById(id);
    }
}
