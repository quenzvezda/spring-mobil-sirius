package com.quenzvezda.mobilApp;

import com.quenzvezda.mobilApp.model.*;
import com.quenzvezda.mobilApp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Profile("seed")
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private JenisMobilRepository jenisMobilRepository;

    @Autowired
    private MobilRepository mobilRepository;

    @Autowired
    private PorcheRepository porcheRepository;

    @Autowired
    private FordRepository fordRepository;

    @Override
    public void run(String... args) throws Exception {
        // Seed data untuk Jenis Mobil
        JenisMobil sedanJenis = new JenisMobil();
        sedanJenis.setNama("Sedan");
        sedanJenis = jenisMobilRepository.save(sedanJenis);

        JenisMobil suvJenis = new JenisMobil();
        suvJenis.setNama("SUV");
        suvJenis = jenisMobilRepository.save(suvJenis);
    }
}
