package org.grupo_e.rungroup.repository;

import org.grupo_e.rungroup.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
