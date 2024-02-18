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
@Table(name = "suv")
public class SUV {
    @Id
    private Long mobilId;

    @Column(name = "kapasitas_penumpang")
    private Integer kapasitasPenumpang;

    @Column(name = "ground_clearance")
    private BigDecimal groundClearance;

    @MapsId
    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;
}
