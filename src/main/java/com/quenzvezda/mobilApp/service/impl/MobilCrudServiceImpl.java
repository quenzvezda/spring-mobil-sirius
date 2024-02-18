package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;
import com.quenzvezda.mobilApp.model.*;
import com.quenzvezda.mobilApp.repository.*;
import com.quenzvezda.mobilApp.service.MobilCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

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

}
