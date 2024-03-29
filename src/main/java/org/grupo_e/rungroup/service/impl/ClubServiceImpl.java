package org.grupo_e.rungroup.service.impl;

import org.grupo_e.rungroup.dto.ClubDto;
import org.grupo_e.rungroup.models.Club;
import org.grupo_e.rungroup.repository.ClubRepository;
import org.grupo_e.rungroup.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    private ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();

        return clubDto;
    }
    @Override
    public List<ClubDto> findAllClubs() {
List<Club> clubs = clubRepository.findAll();
    return clubs.stream().map((club) -> mapToClubDto(club)).collect((Collectors.toList()));
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club1 = mapToClub(clubDto);
        clubRepository.save(club1);
    }

    private Club mapToClub(ClubDto club) {
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
