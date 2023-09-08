package com.springboot.ipl.app.controller;

import com.springboot.ipl.app.entity.Match;
import com.springboot.ipl.app.entity.Team;
import com.springboot.ipl.app.service.TeamService;
import com.springboot.ipl.app.service.TeamServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatchController {

    private TeamService teamService;
    private Logger log = LoggerFactory.getLogger(MatchController.class);

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
  
    @GetMapping("teamName/seasons")
    public List<String> getSeasons() {
        List<String> seasons = teamService.getAllSeason();
        return seasons;
    }

    @GetMapping("teamName")
    public List<Match> getMatchesBySeasons(@RequestParam(name = "firstYear", defaultValue = "2008", required = false) String firstYear,
                                         @RequestParam(name = "secondYear", defaultValue = "2008", required = false) String secondYear) {
        List<Match> matches = teamService.getMatchesBetweenSeasons(firstYear, secondYear);
        log.info("matches -> ", matches);
        return matches;
    }

    @GetMapping("teamName/season/{teamName}") 
    public List<Match> getTeamBtwSeasons(@PathVariable("teamName") String team,
                                        @RequestParam(name = "fistYear", defaultValue = "2008", required = false) String firstYear,
                                        @RequestParam(name = "secondYear", defaultValue = "2008", required = false) String secondYear) {
        List<Match> matches = teamService.getTeamBtwTheSeason(team, firstYear, secondYear);
        return matches;
    }

    // @GetMapping("teamName/{teamName}") 
    // public List<Match> getMatchesByYear(@PathVariable("teamName") String team, 
    //                                     @RequestParam(name = "firstYear", defaultValue = "2023", required = false) String firstYear,
    //                                     @RequestParam(name = "secondYear", defaultValue = "2023", required = false) String secondYear) {
    //     List<Match> matches = teamService.getMatchesBetweenSeasons(firstYear, secondYear);

    //     return matches;
    // }
}
