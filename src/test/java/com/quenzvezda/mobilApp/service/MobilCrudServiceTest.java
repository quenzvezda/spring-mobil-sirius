package com.quenzvezda.mobilApp.service;

import com.quenzvezda.mobilApp.model.Mobil;
import com.quenzvezda.mobilApp.model.Porche;
import com.quenzvezda.mobilApp.model.Sedan;
import org.springframework.boot.test.context.SpringBootTest;

import com.quenzvezda.mobilApp.dto.MobilCreationDto;
import com.quenzvezda.mobilApp.dto.MobilResponseDto;
import com.quenzvezda.mobilApp.repository.*;
import com.quenzvezda.mobilApp.service.impl.MobilCrudServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MobilCrudServiceTest {
    @Mock
    private MobilRepository mobilRepository;
    @Mock
    private SedanRepository sedanRepository;
    @Mock
    private SUVRepository suvRepository;
    @Mock
    private PorcheRepository porcheRepository;
    @Mock
    private FordRepository fordRepository;
    @Mock
    private JenisMobilRepository jenisMobilRepository;

    @InjectMocks
    private MobilCrudServiceImpl mobilCrudService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateMobil() {
        MobilCreationDto mobilCreationDto = new MobilCreationDto();
        // Set properties of mobilCreationDTO based on your test case

        Mobil mockMobil = new Mobil();
        mockMobil.setId(1L);
        mockMobil.setTahun(mobilCreationDto.getTahun());
        mockMobil.setWarna(mobilCreationDto.getWarna());
        mockMobil.setStatus(mobilCreationDto.getStatus());

        when(mobilRepository.save(any(Mobil.class))).thenReturn(mockMobil);

        MobilResponseDto mobilResponseDTO = mobilCrudService.createMobil(mobilCreationDto);

        // Verify that repositories are called with correct parameters
        verify(mobilRepository, times(1)).save(any(Mobil.class));
        verify(jenisMobilRepository, times(1)).save(any());
        // Add more verifications for other repositories based on the jenisMobil and merk

        // Assert the properties of the response
        assertNotNull(mobilResponseDTO);
        assertEquals(mockMobil.getId(), mobilResponseDTO.getMobilId());
        assertEquals(mobilCreationDto.getTahun(), mobilResponseDTO.getTahun());
        assertEquals(mobilCreationDto.getWarna(), mobilResponseDTO.getWarna());
        assertEquals(mobilCreationDto.getStatus(), mobilResponseDTO.getStatus());
        // Add more assertions for other properties of the response
    }

    @Test
    public void testCreateMobilSedanPorche() {
        MobilCreationDto mobilCreationDto = new MobilCreationDto();
        mobilCreationDto.setTahun(2022);
        mobilCreationDto.setWarna("Merah");
        mobilCreationDto.setStatus("Baru");
        mobilCreationDto.setJenisMobil("Sedan");
        mobilCreationDto.setMerk("Porche");
        mobilCreationDto.setPanjangBodi(BigDecimal.valueOf(4.5));
        mobilCreationDto.setTipeAtap("Sunroof");
        mobilCreationDto.setKecepatanMaksimal(300);
        mobilCreationDto.setTipeSuspensi("Sport");

        Mobil mockMobil = new Mobil();
        mockMobil.setId(1L);
        mockMobil.setTahun(2022);
        mockMobil.setWarna("Merah");
        mockMobil.setStatus("Baru");

        when(mobilRepository.save(any(Mobil.class))).thenReturn(mockMobil);
        when(sedanRepository.save(any(Sedan.class))).thenReturn(new Sedan());
        when(porcheRepository.save(any(Porche.class))).thenReturn(new Porche());

        MobilResponseDto mobilResponseDto = mobilCrudService.createMobil(mobilCreationDto);

        assertNotNull(mobilResponseDto);
        assertEquals(1L, mobilResponseDto.getMobilId());
        assertEquals("Sedan", mobilResponseDto.getJenisMobil());
        assertEquals("Porche", mobilResponseDto.getMerk());
        assertEquals(2022, mobilResponseDto.getTahun());
        assertEquals("Merah", mobilResponseDto.getWarna());
        assertEquals("Baru", mobilResponseDto.getStatus());
    }
}
