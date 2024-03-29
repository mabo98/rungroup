package org.grupo_e.rungroup.mapper;

import org.grupo_e.rungroup.dto.EventDto;
import org.grupo_e.rungroup.models.Event;

import java.time.LocalDateTime;

public class EventsMapper {
    public static Event mapToEvent(EventDto eventDto) {
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
    public static EventDto mapToEventDto(Event event) {
        return EventDto.builder()
                .name(event.getName())
                .startTime(String.valueOf(event.getStartTime()))
                .endTime(String.valueOf(event.getEndTime()))
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .build();
    }
}
