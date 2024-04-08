package org.grupo_e.rungroup.service.impl;

import org.grupo_e.rungroup.dto.ClubDto;
import org.grupo_e.rungroup.models.Club;
import org.grupo_e.rungroup.models.UserEntity;
import org.grupo_e.rungroup.repository.ClubRepository;
import org.grupo_e.rungroup.repository.UserRepository;
import org.grupo_e.rungroup.security.SecurityUtil;
import org.grupo_e.rungroup.service.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.grupo_e.rungroup.mapper.ClubMapper.mapToClub;
import static org.grupo_e.rungroup.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;
    private UserRepository userRepository;

    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository){

        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect((Collectors.toList()));
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user =  userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setCreatedBy(user);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user =  userRepository.findByUsername(username);
        Club club1 = mapToClub(clubDto);
        club1.setCreatedBy(user);
        clubRepository.save(club1);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
