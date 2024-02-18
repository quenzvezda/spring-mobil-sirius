package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.SedanDto;
import com.quenzvezda.mobilApp.model.Mobil;
import com.quenzvezda.mobilApp.model.Sedan;
import com.quenzvezda.mobilApp.repository.MobilRepository;
import com.quenzvezda.mobilApp.repository.SedanRepository;
import com.quenzvezda.mobilApp.service.SedanService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SedanServiceImpl implements SedanService {
    private SedanRepository sedanRepository;
    private MobilRepository mobilRepository;

    public SedanServiceImpl(SedanRepository sedanRepository, MobilRepository mobilRepository) {
        this.sedanRepository = sedanRepository;
        this.mobilRepository = mobilRepository;
    }

    @Override
    public List<SedanDto> findAll() {
        return sedanRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SedanDto findById(Long mobilId) {
        Sedan sedan = sedanRepository.findById(mobilId).orElse(null);
        return convertToDTO(sedan);
    }

    @Override
    public SedanDto save(SedanDto sedanDto) {
        Sedan sedan = convertToEntity(sedanDto);
        Sedan savedSedan = sedanRepository.save(sedan);
        return convertToDTO(savedSedan);
    }

    @Override
    public void deleteById(Long mobilId) {
        sedanRepository.deleteById(mobilId);
    }

    private SedanDto convertToDTO(Sedan sedan) {
        return SedanDto.builder()
                .mobilId(sedan.getMobilId())
                .panjangBodi(sedan.getPanjangBodi())
                .tipeAtap(sedan.getTipeAtap())
                .build();
    }

    private Sedan convertToEntity(SedanDto sedanDTO) {
        Sedan sedan = new Sedan();
        sedan.setMobilId(sedanDTO.getMobilId());
        sedan.setPanjangBodi(sedanDTO.getPanjangBodi());
        sedan.setTipeAtap(sedanDTO.getTipeAtap());

        // menangani pengaturan Mobil di sini
        Mobil mobil = mobilRepository.findById(sedanDTO.getMobilId())
                .orElseThrow(() -> new EntityNotFoundException("Mobil not found with id " + sedanDTO.getMobilId()));
        sedan.setMobil(mobil);

        return sedan;
    }
}
