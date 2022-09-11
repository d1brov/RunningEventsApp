package com.portfolio.app.web.controller;

import com.portfolio.app.persistence.model.Event;
import com.portfolio.app.service.EventService;
import com.portfolio.app.web.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("events")
@RequiredArgsConstructor
public class EventsController {
    private final EventService eventService;
    private final ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(OK)
    List<EventDto> getAll() {
        List<Event> allEvents = eventService.getAll();
        return allEvents.stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("byId/{id}")
    @ResponseStatus(OK)
    EventDto getUserById(@PathVariable Integer id) {
        Event foundEvent = eventService.getById(id);
        return modelMapper.map(foundEvent, EventDto.class);
    }
}