package org.grupo_e.rungroup.service;

import org.grupo_e.rungroup.dto.EventDto;

import java.util.List;

public interface EventService {
    void createEvent(long clubId, EventDto eventDto);
    List<EventDto> findAllEvents();

    EventDto findEventById(long eventId);
}
