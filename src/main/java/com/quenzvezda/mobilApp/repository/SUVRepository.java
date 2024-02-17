package com.quenzvezda.mobilApp.repository;

import com.quenzvezda.mobilApp.model.SUV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SUVRepository extends JpaRepository<SUV, Long> {
}
