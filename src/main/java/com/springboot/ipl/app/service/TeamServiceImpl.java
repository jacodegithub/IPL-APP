package com.springboot.ipl.app.service;

import com.springboot.ipl.app.entity.Match;
import com.springboot.ipl.app.entity.Team;
import com.springboot.ipl.app.repository.MatchRepository;
import com.springboot.ipl.app.repository.TeamRepository;

import org.hibernate.mapping.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService{

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    private Logger log = LoggerFactory.getLogger(TeamServiceImpl.class);

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team getTeamByName(String teamName) {
        return teamRepository.findTeamByTeamName(teamName);
    }

    @Override
    public List<Match> getMatchDetails(String teamName, Integer pageNumber) {
        Pageable pages = PageRequest.of(pageNumber, 5);
        List<Match> matches = matchRepository.findMatchByTeam1OrTeam2OrderByStartDateDesc(teamName, teamName, pages);
//                .map(Collections::singletonList)
//                .orElse(Collections.emptyList());
        return matches;
    }

    @Override
    public List<Match> getAllMatches(String team) {
       List<Match> matches = matchRepository.findMatchByTeam1OrTeam2(team, team);
       return matches;
    }

    @Override
    public List<String> getAllSeason() {
        List<String> seasons = matchRepository.findAllSeason();
        return seasons;
    }

    @Override
    public List<Match> getMatchesBetweenSeasons(String first, String second) {
        List<Match> matches = matchRepository.findMatchBySeasonBetween(first, second);
        return matches;
    }

    @Override
    public List<Match> getTeamBtwTheSeason(String team, String first, String second) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getTeamBtwTheSeason'");

        List<Match> matches = matchRepository.findMatchByTeam1OrTeam2AndSeasonBetween(team, team, first, second);

        return matches;
    }

    // @Override
    // public List<Match> getMatchesBetweenSeasons(String first, String second) {
        
    //     Optional<Object[]> matches = matchRepository.findMatchesBySeason(first, second);
       
    //     if(matches.isPresent()) {
    //         Object[] object = matches.get();
    //         String team1 = (String) object[0];
    //         String team2 = (String) object[1];

    //         Match match = new Match();
    //         match.setTeam1(team1);
    //         match.setTeam2(team2);

    //        return Collections.singletonList(match);
    //     }        
    //     return Collections.emptyList();
    // }
}
