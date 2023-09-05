package com.springboot.ipl.app.service;

import com.springboot.ipl.app.entity.Match;
import com.springboot.ipl.app.entity.Team;
import com.springboot.ipl.app.repository.MatchRepository;
import com.springboot.ipl.app.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

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
}
