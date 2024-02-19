package com.quenzvezda.mobilApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mobil")
public class Mobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_rangka")
    private String noRangka;
    private Integer tahun;
    private String warna;
    private String status;

    @OneToOne(mappedBy = "mobil", cascade = CascadeType.ALL)
    private Sedan sedan;

    @OneToOne(mappedBy = "mobil", cascade = CascadeType.ALL)
    private SUV suv;

    @OneToOne(mappedBy = "mobil", cascade = CascadeType.ALL)
    private Porche porche;

    @OneToOne(mappedBy = "mobil", cascade = CascadeType.ALL)
    private Ford ford;

    @OneToMany(mappedBy = "mobil", cascade = CascadeType.ALL)
    private Set<Roda> roda;
}
