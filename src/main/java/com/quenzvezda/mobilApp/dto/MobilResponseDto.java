package com.quenzvezda.mobilApp.dto;

import lombok.Data;

@Data
public class MobilResponseDto {
    private Long mobilId;
    private String jenisMobil; // "Sedan" atau "SUV"
    private String merk; // "Ford" atau "Porche"
    private Integer tahun;
    private String warna;
    private String status;

    // Spesifik untuk Sedan dan SUV
    private Double panjangBodi; // Untuk Sedan
    private String tipeAtap; // Untuk Sedan
    private Integer kapasitasPenumpang; // Untuk SUV
    private Double groundClearance; // Untuk SUV

    // Spesifik untuk Porche dan Ford
    private Integer kecepatanMaksimal; // Untuk Porche
    private String tipeSuspensi; // Untuk Porche
    private String tipeMesin; // Untuk Ford
    private Integer kapasitasTangkiBahanBakar; // Untuk Ford
}
