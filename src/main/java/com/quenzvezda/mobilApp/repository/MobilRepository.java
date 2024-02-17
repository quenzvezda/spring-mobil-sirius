package com.quenzvezda.mobilApp.repository;

import com.quenzvezda.mobilApp.model.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRepository extends JpaRepository<Mobil, Long> {
}
