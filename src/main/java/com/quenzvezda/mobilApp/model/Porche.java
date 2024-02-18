package com.quenzvezda.mobilApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "porche")
public class Porche {
    @Id
    private Long mobilId;

    @Column(name = "kecepatan_maksimal")
    private Integer kecepatanMaksimal;

    @Column(name = "tipe_suspensi")
    private String tipeSuspensi;

    @MapsId
    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;

    @ManyToOne
    @JoinColumn(name = "jenis_mobil_id", referencedColumnName = "id")
    private JenisMobil jenisMobil;
}
