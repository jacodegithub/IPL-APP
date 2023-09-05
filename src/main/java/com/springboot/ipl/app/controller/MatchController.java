package com.springboot.ipl.app.controller;

import com.springboot.ipl.app.entity.Match;
import com.springboot.ipl.app.entity.Team;
import com.springboot.ipl.app.service.TeamService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatchController {

    private TeamService teamService;

    public MatchController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("teamName/{teamName}")
    public Team getTeamByName(@PathVariable String teamName,
                              @RequestParam(name = "pageNumber", defaultValue = "0", required = false) Integer pageNumber) {
        Team team = teamService.getTeamByName(teamName);
        team.setMatches(teamService.getMatchDetails(teamName, pageNumber));
        return team;
    }

    @GetMapping("teamName/matches/{teamName}")
    public List<Match> getAllMatches(@PathVariable("teamName") String team) {
        List<Match> matches = teamService.getAllMatches(team);
        return matches;
    }

}
