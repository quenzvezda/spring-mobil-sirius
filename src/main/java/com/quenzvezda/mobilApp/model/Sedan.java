package com.quenzvezda.mobilApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "Sedan")
public class Sedan {
    @Id
    private Long mobilId;
    private BigDecimal panjangBodi;
    private String tipeAtap;

    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;
}
