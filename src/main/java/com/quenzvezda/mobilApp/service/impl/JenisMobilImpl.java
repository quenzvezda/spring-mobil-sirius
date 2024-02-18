package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.JenisMobilDto;
import com.quenzvezda.mobilApp.model.JenisMobil;
import com.quenzvezda.mobilApp.repository.JenisMobilRepository;
import com.quenzvezda.mobilApp.service.JenisMobilService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JenisMobilImpl implements JenisMobilService {
    private JenisMobilRepository jenisMobilRepository;

    @Override
    public List<JenisMobilDto> findAll() {
        return jenisMobilRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JenisMobilDto findById(Long id) {
        JenisMobil jenisMobil = jenisMobilRepository.findById(id).orElse(null);
        return convertToDTO(jenisMobil);
    }

    @Override
    public JenisMobilDto save(JenisMobilDto jenisMobilDTO) {
        JenisMobil jenisMobil = convertToEntity(jenisMobilDTO);
        JenisMobil savedJenisMobil = jenisMobilRepository.save(jenisMobil);
        return convertToDTO(savedJenisMobil);
    }

    @Override
    public void deleteById(Long id) {
        jenisMobilRepository.deleteById(id);
    }

    private JenisMobilDto convertToDTO(JenisMobil jenisMobil) {
        return JenisMobilDto.builder()
                .id(jenisMobil.getId())
                .nama(jenisMobil.getNama())
                .build();
    }

    private JenisMobil convertToEntity(JenisMobilDto jenisMobilDTO) {
        JenisMobil jenisMobil = new JenisMobil();
        jenisMobil.setId(jenisMobilDTO.getId());
        jenisMobil.setNama(jenisMobilDTO.getNama());
        return jenisMobil;
    }
}
