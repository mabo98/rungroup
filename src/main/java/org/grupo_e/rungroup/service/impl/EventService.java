package org.grupo_e.rungroup.service.impl;

import org.grupo_e.rungroup.dto.EventDto;

public interface EventService {
    void createEvent(long clubId, EventDto eventDto);
}
