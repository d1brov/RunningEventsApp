package com.portfolio.app.persistence.repository;

import com.portfolio.app.persistence.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    List<Event> findAll();

    Optional<Event> findById(Integer id);
}
