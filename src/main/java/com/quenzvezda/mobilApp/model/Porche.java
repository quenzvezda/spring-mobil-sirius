package com.quenzvezda.mobilApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Porsche")
public class Porche {
    @Id
    private Long mobilId;
    private Integer kecepatanMaksimal;
    private String tipeSuspensi;

    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;

    @ManyToOne
    @JoinColumn(name = "jenis_mobil_id", referencedColumnName = "id")
    private JenisMobil jenisMobil;
}