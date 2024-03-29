package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.PorcheDto;
import com.quenzvezda.mobilApp.model.Mobil;
import com.quenzvezda.mobilApp.model.Porche;
import com.quenzvezda.mobilApp.repository.MobilRepository;
import com.quenzvezda.mobilApp.repository.PorcheRepository;
import com.quenzvezda.mobilApp.service.PorcheService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PorcheServiceImpl implements PorcheService {
    private PorcheRepository porcheRepository;
    private MobilRepository mobilRepository;

    public PorcheServiceImpl(PorcheRepository porcheRepository, MobilRepository mobilRepository) {
        this.porcheRepository = porcheRepository;
        this.mobilRepository = mobilRepository;
    }

    @Override
    public List<PorcheDto> findAll() {
        return porcheRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PorcheDto findById(Long mobilId) {
        Porche porche = porcheRepository.findById(mobilId).orElse(null);
        return convertToDto(porche);
    }

    @Override
    public PorcheDto save(PorcheDto porcheDto) {
        Porche porche = convertToEntity(porcheDto);
        Porche savedPorche = porcheRepository.save(porche);
        return convertToDto(savedPorche);
    }

    @Override
    public void deleteById(Long mobilId) {
        porcheRepository.deleteById(mobilId);
    }

    private PorcheDto convertToDto(Porche porche) {
        return PorcheDto.builder()
                .mobilId(porche.getMobilId())
                .jenisMobilId(porche.getJenisMobil() != null ? porche.getJenisMobil().getId() : null)
                .kecepatanMaksimal(porche.getKecepatanMaksimal())
                .tipeSuspensi(porche.getTipeSuspensi())
                .build();
    }

    private Porche convertToEntity(PorcheDto porcheDto) {
        Porche porche = new Porche();
        porche.setMobilId(porcheDto.getMobilId());
        porche.setKecepatanMaksimal(porcheDto.getKecepatanMaksimal());
        porche.setTipeSuspensi(porcheDto.getTipeSuspensi());

        // Anda perlu menangani pengaturan JenisMobil di sini
        Mobil mobil = mobilRepository.findById(porcheDto.getMobilId())
                .orElseThrow(() -> new EntityNotFoundException("Mobil not found with id " + porcheDto.getMobilId()));
        porche.setMobil(mobil);

        return porche;
    }
}
