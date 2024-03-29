package org.grupo_e.rungroup.service.impl;

import org.grupo_e.rungroup.dto.EventDto;
import org.grupo_e.rungroup.models.Club;
import org.grupo_e.rungroup.models.Event;
import org.grupo_e.rungroup.repository.ClubRepository;
import org.grupo_e.rungroup.repository.EventRepository;
import org.grupo_e.rungroup.service.EventService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.grupo_e.rungroup.mapper.EventsMapper.mapToEvent;
import static org.grupo_e.rungroup.mapper.EventsMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final ClubRepository clubRepository;


    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).orElseThrow(() -> new RuntimeException("Club not found"));
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto findEventById(long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

}
