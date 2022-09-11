package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.Race;
import com.portfolio.app.persistence.repository.RaceRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceJpaRepository extends RaceRepository, JpaRepository<Race, Integer> {
}
