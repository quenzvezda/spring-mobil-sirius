package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.SUVDto;
import com.quenzvezda.mobilApp.model.Mobil;
import com.quenzvezda.mobilApp.model.SUV;
import com.quenzvezda.mobilApp.repository.MobilRepository;
import com.quenzvezda.mobilApp.repository.SUVRepository;
import com.quenzvezda.mobilApp.service.SUVService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SUVServiceImpl implements SUVService {
    private SUVRepository suvRepository;
    private MobilRepository mobilRepository;

    public SUVServiceImpl(SUVRepository suvRepository, MobilRepository mobilRepository) {
        this.suvRepository = suvRepository;
        this.mobilRepository = mobilRepository;
    }

    @Override
    public List<SUVDto> findAll() {
        return suvRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SUVDto findById(Long mobilId) {
        SUV suv = suvRepository.findById(mobilId).orElse(null);
        return convertToDTO(suv);
    }

    @Override
    public SUVDto save(SUVDto suvDto) {
        SUV suv = convertToEntity(suvDto);
        SUV savedSUV = suvRepository.save(suv);
        return convertToDTO(savedSUV);
    }

    @Override
    public void deleteById(Long mobilId) {
        suvRepository.deleteById(mobilId);
    }

    private SUVDto convertToDTO(SUV suv) {
        return SUVDto.builder()
                .mobilId(suv.getMobilId())
                .kapasitasPenumpang(suv.getKapasitasPenumpang())
                .groundClearance(suv.getGroundClearance())
                .build();
    }

    private SUV convertToEntity(SUVDto suvDto) {
        SUV suv = new SUV();
        suv.setMobilId(suvDto.getMobilId());
        suv.setKapasitasPenumpang(suvDto.getKapasitasPenumpang());
        suv.setGroundClearance(suvDto.getGroundClearance());

        // menangani pengaturan Mobil di sini
        Mobil mobil = mobilRepository.findById(suvDto.getMobilId())
                .orElseThrow(() -> new EntityNotFoundException("Mobil not found with id " + suvDto.getMobilId()));
        suv.setMobil(mobil);

        return suv;
    }
}
