package org.grupo_e.rungroup.service;

import org.grupo_e.rungroup.dto.ClubDto;
import org.grupo_e.rungroup.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);

    void delete(Long clubId);

    List<ClubDto> searchClubs(String query);
}
