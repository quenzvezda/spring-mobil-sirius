package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.MobilDto;
import com.quenzvezda.mobilApp.model.Mobil;
import com.quenzvezda.mobilApp.repository.MobilRepository;
import com.quenzvezda.mobilApp.service.MobilService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class MobilServiceImpl implements MobilService {
    private final MobilRepository mobilRepository;

    public MobilServiceImpl(MobilRepository mobilRepository) {
        this.mobilRepository = mobilRepository;
    }

    @Override
    public List<MobilDto> findAll() {
        return mobilRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MobilDto findById(Long id) {
        Mobil mobil = mobilRepository.findById(id).orElse(null);
        return convertToDTO(mobil);
    }

    @Override
    public MobilDto save(MobilDto mobilDTO) {
        Mobil mobil = convertToEntity(mobilDTO);
        Mobil savedMobil = mobilRepository.save(mobil);
        return convertToDTO(savedMobil);
    }

    @Override
    public void deleteById(Long id) {
        mobilRepository.deleteById(id);
    }

    private MobilDto convertToDTO(Mobil mobil) {
        return MobilDto.builder()
                .id(mobil.getId())
                .noRangka(mobil.getNoRangka())
                .tahun(mobil.getTahun())
                .warna(mobil.getWarna())
                .status(mobil.getStatus())
                .build();
    }

    private Mobil convertToEntity(MobilDto mobilDTO) {
        return Mobil.builder()
                .id(mobilDTO.getId())
                .noRangka(mobilDTO.getNoRangka())
                .tahun(mobilDTO.getTahun())
                .warna(mobilDTO.getWarna())
                .status(mobilDTO.getStatus())
                .build();
    }
}
