package org.grupo_e.rungroup.service.impl;

import org.grupo_e.rungroup.dto.EventDto;
import org.grupo_e.rungroup.models.Club;
import org.grupo_e.rungroup.models.Event;
import org.grupo_e.rungroup.repository.ClubRepository;
import org.grupo_e.rungroup.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventServiceImpl implements EventService{
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
    private Event mapToEvent(EventDto eventDto) {
        return Event.builder()
                .name(eventDto.getName())
                .startTime(LocalDateTime.parse(eventDto.getStartTime()))
                .endTime(LocalDateTime.parse(eventDto.getEndTime()))
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .build();
    }
}
