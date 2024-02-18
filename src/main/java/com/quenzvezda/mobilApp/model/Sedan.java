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
@Table(name = "sedan")
public class Sedan {
    @Id
    private Long mobilId;

    @Column(name = "panjang_bodi")
    private BigDecimal panjangBodi;

    @Column(name = "tipe_atap")
    private String tipeAtap;

    @MapsId
    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;
}
