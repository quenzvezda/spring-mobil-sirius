package com.quenzvezda.mobilApp.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MobilCreationDto {
    private String noRangka; // Tambahkan field ini
    private Integer tahun;
    private String warna;
    private String status;

    private String jenisMobil; // "Sedan" atau "SUV"
    private String merk; // "Ford" atau "Porche"

    // Spesifik untuk Sedan
    private BigDecimal panjangBodi;
    private String tipeAtap;

    // Spesifik untuk SUV
    private Integer kapasitasPenumpang;
    private BigDecimal groundClearance;

    // Spesifik untuk Porche
    private Integer kecepatanMaksimal;
    private String tipeSuspensi;

    // Spesifik untuk Ford
    private String tipeMesin;
    private Integer kapasitasTangkiBahanBakar;

    // Informasi tentang roda
    private List<RodaDto> roda;
}
