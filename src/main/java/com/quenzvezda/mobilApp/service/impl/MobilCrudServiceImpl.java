package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilDetailDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;
import com.quenzvezda.mobilApp.model.*;
import com.quenzvezda.mobilApp.repository.*;
import com.quenzvezda.mobilApp.service.MobilCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class MobilCrudServiceImpl implements MobilCrudService {
    @Autowired
    private MobilRepository mobilRepository;
    @Autowired
    private SedanRepository sedanRepository;
    @Autowired
    private SUVRepository suvRepository;
    @Autowired
    private PorcheRepository porcheRepository;
    @Autowired
    private FordRepository fordRepository;
    @Autowired
    private JenisMobilRepository jenisMobilRepository;

    @Override
    @Transactional
    public MobilResponseDto createMobil(MobilCreationDto mobilCreationDto) {
        Mobil mobil = new Mobil();
        mobil.setNoRangka(mobilCreationDto.getNoRangka());
        mobil.setTahun(mobilCreationDto.getTahun());
        mobil.setWarna(mobilCreationDto.getWarna());
        mobil.setStatus(mobilCreationDto.getStatus());
        mobil = mobilRepository.save(mobil);

        if ("sedan".equalsIgnoreCase(mobilCreationDto.getJenisMobil())) {
            Sedan sedan = new Sedan();
            sedan.setMobil(mobil);
            sedan.setPanjangBodi(mobilCreationDto.getPanjangBodi());
            sedan.setTipeAtap(mobilCreationDto.getTipeAtap());
            sedanRepository.save(sedan);
        } else if ("suv".equalsIgnoreCase(mobilCreationDto.getJenisMobil())) {
            SUV suv = new SUV();
            suv.setMobil(mobil);
            suv.setKapasitasPenumpang(mobilCreationDto.getKapasitasPenumpang());
            suv.setGroundClearance(mobilCreationDto.getGroundClearance());
            suvRepository.save(suv);
        }


        if ("porche".equalsIgnoreCase(mobilCreationDto.getMerk())) {
            Porche porche = new Porche();
            porche.setMobil(mobil);
            porche.setKecepatanMaksimal(mobilCreationDto.getKecepatanMaksimal());
            porche.setTipeSuspensi(mobilCreationDto.getTipeSuspensi());
            // Set jenis_mobil_id berdasarkan jenisMobil
            if ("sedan".equalsIgnoreCase(mobilCreationDto.getJenisMobil())) {
                porche.setJenisMobil(jenisMobilRepository.findById(1L).orElse(null));
            } else if ("suv".equalsIgnoreCase(mobilCreationDto.getJenisMobil())) {
                porche.setJenisMobil(jenisMobilRepository.findById(2L).orElse(null));
            }
            porcheRepository.save(porche);
        } else if ("ford".equalsIgnoreCase(mobilCreationDto.getMerk())) {
            Ford ford = new Ford();
            ford.setMobil(mobil);
            ford.setTipeMesin(mobilCreationDto.getTipeMesin());
            ford.setKapasitasTangkiBahanBakar(mobilCreationDto.getKapasitasTangkiBahanBakar());
            // Set jenis_mobil_id berdasarkan jenisMobil
            if ("sedan".equalsIgnoreCase(mobilCreationDto.getJenisMobil())) {
                ford.setJenisMobil(jenisMobilRepository.findById(1L).orElse(null));
            } else if ("suv".equalsIgnoreCase(mobilCreationDto.getJenisMobil())) {
                ford.setJenisMobil(jenisMobilRepository.findById(2L).orElse(null));
            }
            fordRepository.save(ford);
        }


        MobilResponseDto responseDto = new MobilResponseDto();
        responseDto.setMobilId(mobil.getId());
        responseDto.setTahun(mobil.getTahun());
        responseDto.setWarna(mobil.getWarna());
        responseDto.setStatus(mobil.getStatus());
        responseDto.setJenisMobil(mobilCreationDto.getJenisMobil());
        responseDto.setMerk(mobilCreationDto.getMerk());
        // Set other properties of responseDto based on the created entities
        return responseDto;
    }

    @Override
    public List<MobilDetailDto> getAllMobilDetails() {
        return mobilRepository.findAll().stream().map(this::convertToMobilDetailDto).collect(Collectors.toList());
    }

    private MobilDetailDto convertToMobilDetailDto(Mobil mobil) {
        MobilDetailDto dto = new MobilDetailDto();
        dto.setMobilId(mobil.getId());
        dto.setNoRangka(mobil.getNoRangka());
        dto.setTahun(mobil.getTahun());
        dto.setWarna(mobil.getWarna());
        dto.setStatus(mobil.getStatus());

        // Tentukan jenis mobil dan merk
        if (mobil.getSedan() != null) {
            dto.setJenisMobil("Sedan");
            dto.setPanjangBodi(mobil.getSedan().getPanjangBodi());
            dto.setTipeAtap(mobil.getSedan().getTipeAtap());
        } else if (mobil.getSuv() != null) {
            dto.setJenisMobil("SUV");
            dto.setKapasitasPenumpang(mobil.getSuv().getKapasitasPenumpang());
            dto.setGroundClearance(mobil.getSuv().getGroundClearance());
        }

        if (mobil.getPorche() != null) {
            dto.setMerk("Porche");
            dto.setKecepatanMaksimal(mobil.getPorche().getKecepatanMaksimal());
            dto.setTipeSuspensi(mobil.getPorche().getTipeSuspensi());
        } else if (mobil.getFord() != null) {
            dto.setMerk("Ford");
            dto.setTipeMesin(mobil.getFord().getTipeMesin());
            dto.setKapasitasTangkiBahanBakar(mobil.getFord().getKapasitasTangkiBahanBakar());
        }

        return dto;
    }

    @Override
    public void deleteMobil(Long mobilId) {
        // Cek apakah mobil dengan ID tersebut ada di database
        if (!mobilRepository.existsById(mobilId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mobil dengan ID " + mobilId + " tidak ditemukan");
        }
        mobilRepository.deleteById(mobilId);
    }

    @Override
    public MobilDetailDto findMobilById(Long mobilId) {
        Mobil mobil = mobilRepository.findById(mobilId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mobil dengan ID " + mobilId + " tidak ditemukan"));
        return convertToMobilDetailDto(mobil);
    }
}
