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
@Table(name = "Ford")
public class Ford {
    @Id
    private Long mobilId;
    private String tipeMesin;
    private Integer kapasitasTangkiBahanBakar;

    @OneToOne
    @JoinColumn(name = "mobil_id", referencedColumnName = "id")
    private Mobil mobil;

    @ManyToOne
    @JoinColumn(name = "jenis_mobil_id", referencedColumnName = "id")
    private JenisMobil jenisMobil;
}