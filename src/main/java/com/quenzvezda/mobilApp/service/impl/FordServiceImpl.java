package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.FordDto;
import com.quenzvezda.mobilApp.model.Ford;
import com.quenzvezda.mobilApp.model.Mobil;
import com.quenzvezda.mobilApp.repository.FordRepository;
import com.quenzvezda.mobilApp.repository.MobilRepository;
import com.quenzvezda.mobilApp.service.FordService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FordServiceImpl implements FordService {
    private FordRepository fordRepository;
    private MobilRepository mobilRepository;

    public FordServiceImpl(FordRepository fordRepository, MobilRepository mobilRepository) {
        this.fordRepository = fordRepository;
        this.mobilRepository = mobilRepository;
    }

    @Override
    public List<FordDto> findAll() {
        return fordRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FordDto findById(Long mobilId) {
        Ford ford = fordRepository.findById(mobilId).orElse(null);
        return convertToDto(ford);
    }

    @Override
    public FordDto save(FordDto fordDto) {
        Ford ford = convertToEntity(fordDto);
        Ford savedFord = fordRepository.save(ford);
        return convertToDto(savedFord);
    }

    @Override
    public void deleteById(Long mobilId) {
        fordRepository.deleteById(mobilId);
    }

    private FordDto convertToDto(Ford ford) {
        return FordDto.builder()
                .mobilId(ford.getMobilId())
                .tipeMesin(ford.getTipeMesin())
                .kapasitasTangkiBahanBakar(ford.getKapasitasTangkiBahanBakar())
                .jenisMobilId(ford.getJenisMobil() != null ? ford.getJenisMobil().getId() : null)
                .build();
    }

    private Ford convertToEntity(FordDto fordDto) {
        Ford ford = new Ford();
        ford.setMobilId(fordDto.getMobilId());
        ford.setTipeMesin(fordDto.getTipeMesin());
        ford.setKapasitasTangkiBahanBakar(fordDto.getKapasitasTangkiBahanBakar());

        // menangani pengaturan JenisMobil di sini
        Mobil mobil = mobilRepository.findById(fordDto.getMobilId())
                .orElseThrow(() -> new EntityNotFoundException("Mobil not found with id " + fordDto.getMobilId()));
        ford.setMobil(mobil);

        return ford;
    }
}
