package com.quenzvezda.mobilApp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MobilCreationDto {
    // Informasi umum mobil
    private Integer tahun;
    private String warna;
    private String status;

    // Spesifik untuk Sedan
    private String jenisMobil; // "Sedan" atau "SUV"
    private String merk; // "Ford" atau "Porche"
    private BigDecimal panjangBodi; // Hanya untuk Sedan
    private String tipeAtap; // Hanya untuk Sedan

    // Spesifik untuk SUV
    private Integer kapasitasPenumpang; // Hanya untuk SUV
    private BigDecimal groundClearance; // Hanya untuk SUV

    // Spesifik untuk Porche
    private Integer kecepatanMaksimal; // Hanya untuk Porche
    private String tipeSuspensi; // Hanya untuk Porche

    // Spesifik untuk Ford
    private String tipeMesin; // Hanya untuk Ford
    private Integer kapasitasTangkiBahanBakar; // Hanya untuk Ford
}
