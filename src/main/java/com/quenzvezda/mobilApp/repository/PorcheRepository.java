package com.quenzvezda.mobilApp.repository;

import com.quenzvezda.mobilApp.model.Porche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorcheRepository extends JpaRepository<Porche, Long> {
}
