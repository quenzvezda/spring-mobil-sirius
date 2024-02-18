package com.quenzvezda.mobilApp.service.impl;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;
import com.quenzvezda.mobilApp.model.*;
import com.quenzvezda.mobilApp.repository.*;
import com.quenzvezda.mobilApp.service.MobilCrudService;
import org.springframework.transaction.annotation.Transactional;

public class MobilCrudServiceImpl implements MobilCrudService {
    private MobilRepository mobilRepository;
    private SedanRepository sedanRepository;
    private SUVRepository suvRepository;
    private PorcheRepository porcheRepository;
    private FordRepository fordRepository;
    private JenisMobilRepository jenisMobilRepository;

    @Override
    @Transactional
    public MobilResponseDto createMobil(MobilCreationDto mobilCreationDto) {
        Mobil mobil = new Mobil();
        mobil.setTahun(mobilCreationDto.getTahun());
        mobil.setWarna(mobilCreationDto.getWarna());
        mobil.setStatus(mobilCreationDto.getStatus());
        mobil = mobilRepository.save(mobil);

        JenisMobil jenisMobil = new JenisMobil();
        jenisMobil.setNama(mobilCreationDto.getJenisMobil());
        jenisMobil = jenisMobilRepository.save(jenisMobil);

        if ("Sedan".equals(mobilCreationDto.getJenisMobil())) {
            Sedan sedan = new Sedan();
            sedan.setMobil(mobil);
            sedan.setPanjangBodi(mobilCreationDto.getPanjangBodi());
            sedan.setTipeAtap(mobilCreationDto.getTipeAtap());
            sedanRepository.save(sedan);
        } else if ("SUV".equals(mobilCreationDto.getJenisMobil())) {
            SUV suv = new SUV();
            suv.setMobil(mobil);
            suv.setKapasitasPenumpang(mobilCreationDto.getKapasitasPenumpang());
            suv.setGroundClearance(mobilCreationDto.getGroundClearance());
            suvRepository.save(suv);
        }

        if ("Porche".equals(mobilCreationDto.getMerk())) {
            Porche porche = new Porche();
            porche.setMobil(mobil);
            porche.setJenisMobil(jenisMobil);
            porche.setKecepatanMaksimal(mobilCreationDto.getKecepatanMaksimal());
            porche.setTipeSuspensi(mobilCreationDto.getTipeSuspensi());
            porcheRepository.save(porche);
        } else if ("Ford".equals(mobilCreationDto.getMerk())) {
            Ford ford = new Ford();
            ford.setMobil(mobil);
            ford.setJenisMobil(jenisMobil);
            ford.setTipeMesin(mobilCreationDto.getTipeMesin());
            ford.setKapasitasTangkiBahanBakar(mobilCreationDto.getKapasitasTangkiBahanBakar());
            fordRepository.save(ford);
        }

        // Buat dan kembalikan MobilResponseDTO
        MobilResponseDto responseDTO = new MobilResponseDto();
        responseDTO.setMobilId(mobil.getId());
        responseDTO.setJenisMobil(mobilCreationDto.getJenisMobil());
        responseDTO.setMerk(mobilCreationDto.getMerk());
        responseDTO.setTahun(mobil.getTahun());
        responseDTO.setWarna(mobil.getWarna());
        responseDTO.setStatus(mobil.getStatus());
        // Set other properties of responseDTO based on the created entities
        return responseDTO;
    }
}
