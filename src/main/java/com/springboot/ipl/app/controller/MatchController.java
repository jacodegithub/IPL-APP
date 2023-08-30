package com.springboot.ipl.app.controller;

import com.springboot.ipl.app.entity.Team;
import com.springboot.ipl.app.service.TeamService;
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
                              @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber) {
        Team team = teamService.getTeamByName(teamName);
        team.setMatches(teamService.getMatchDetails(teamName, pageNumber));
        return team;
    }

}
