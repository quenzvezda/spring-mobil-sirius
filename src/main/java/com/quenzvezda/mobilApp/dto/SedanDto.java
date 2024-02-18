package com.quenzvezda.mobilApp.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SedanDto {
    private Long mobilId;
    private BigDecimal panjangBodi;
    private String tipeAtap;
}
