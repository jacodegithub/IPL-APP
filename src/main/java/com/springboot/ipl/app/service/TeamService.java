package com.springboot.ipl.app.service;

import com.springboot.ipl.app.entity.Match;
import com.springboot.ipl.app.entity.Team;

import java.util.List;

public interface TeamService {

    Team getTeamByName(String teamName);

    List<Match> getMatchDetails(String teamName, Integer pageNumber);
}
