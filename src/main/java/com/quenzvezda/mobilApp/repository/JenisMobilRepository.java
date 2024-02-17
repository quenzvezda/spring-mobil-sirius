package com.quenzvezda.mobilApp.repository;

import com.quenzvezda.mobilApp.model.JenisMobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenisMobilRepository extends JpaRepository<JenisMobil, Long> {
}
