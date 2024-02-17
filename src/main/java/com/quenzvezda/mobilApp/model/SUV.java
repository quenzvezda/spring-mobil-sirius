package com.quenzvezda.mobilApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SUV")
public class SUV {
    @Id
    private Long mobilId;
    private Integer kapasitasPenumpang;
    private BigDecimal groundClearance;

    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;
}
