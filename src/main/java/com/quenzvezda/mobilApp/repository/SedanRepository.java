package com.quenzvezda.mobilApp.repository;

import com.quenzvezda.mobilApp.model.Sedan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedanRepository extends JpaRepository<Sedan, Long> {
}
