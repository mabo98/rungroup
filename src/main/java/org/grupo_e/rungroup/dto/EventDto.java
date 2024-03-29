package org.grupo_e.rungroup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class EventDto {
    private long id;
    private String name;
    private String startTime;
    private String endTime;
    private String type;
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
