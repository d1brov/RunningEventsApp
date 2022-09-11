package com.portfolio.app.service;

import com.portfolio.app.persistence.model.Event;
import com.portfolio.app.persistence.repository.EventRepository;
import com.portfolio.app.web.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event getById(Integer id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Event with id: %s not found", id)));
    }
}