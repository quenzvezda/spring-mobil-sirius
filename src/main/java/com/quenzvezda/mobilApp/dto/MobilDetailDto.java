package com.quenzvezda.mobilApp.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MobilDetailDto {
    private Long mobilId;
    private String noRangka;
    private Integer tahun;
    private String warna;
    private String status;
    private String jenisMobil;
    private String merk;
    private BigDecimal panjangBodi;
    private String tipeAtap;
    private Integer kapasitasPenumpang;
    private BigDecimal groundClearance;
    private Integer kecepatanMaksimal;
    private String tipeSuspensi;
    private String tipeMesin;
    private Integer kapasitasTangkiBahanBakar;

    private List<RodaDto> roda;
}
