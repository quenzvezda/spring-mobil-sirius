package com.quenzvezda.mobilApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ford")
public class Ford {
    @Id
    private Long mobilId;

    @Column(name = "tipe_mesin")
    private String tipeMesin;

    @Column(name = "kapasitas_tangki_bahan_bakar")
    private Integer kapasitasTangkiBahanBakar;

    @MapsId
    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;

    @ManyToOne
    @JoinColumn(name = "jenis_mobil_id", referencedColumnName = "id")
    private JenisMobil jenisMobil;
}
