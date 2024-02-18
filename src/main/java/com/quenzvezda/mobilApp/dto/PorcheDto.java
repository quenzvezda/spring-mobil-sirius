package com.quenzvezda.mobilApp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PorcheDto {
    private Long mobilId;
    private Long jenisMobilId;
    private Integer kecepatanMaksimal;
    private String tipeSuspensi;
}
