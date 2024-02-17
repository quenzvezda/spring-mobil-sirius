package com.quenzvezda.mobilApp.repository;

import com.quenzvezda.mobilApp.model.Ford;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FordRepository extends JpaRepository<Ford, Long> {
}
