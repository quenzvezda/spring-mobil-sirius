package com.quenzvezda.mobilApp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FordDto {
    private Long mobilId;
    private String tipeMesin;
    private Integer kapasitasTangkiBahanBakar;
    private Long jenisMobilId;
}
