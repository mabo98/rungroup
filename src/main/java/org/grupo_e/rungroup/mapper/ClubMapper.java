package org.grupo_e.rungroup.mapper;

import org.grupo_e.rungroup.dto.ClubDto;
import org.grupo_e.rungroup.models.Club;

import java.util.stream.Collectors;

import static org.grupo_e.rungroup.mapper.EventsMapper.mapToEventDto;

public class ClubMapper {
    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();

        return clubDto;
    }
    public static Club mapToClub(ClubDto club) {
        Club club1 = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return club1;
    }
}
