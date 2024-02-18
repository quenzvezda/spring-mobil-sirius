package com.quenzvezda.mobilApp.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SUVDto {
    private Long mobilId;
    private Integer kapasitasPenumpang;
    private BigDecimal groundClearance;
}
