package com.quenzvezda.mobilApp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MobilDto {
    private Long id;
    private String noRangka;
    private Integer tahun;
    private String warna;
    private String status;
}
