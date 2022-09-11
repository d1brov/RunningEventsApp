package com.portfolio.app.persistence.repository.jpa;

import com.portfolio.app.persistence.model.Event;
import com.portfolio.app.persistence.repository.EventRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventJpaRepository extends EventRepository, JpaRepository<Event, Integer> {
}
