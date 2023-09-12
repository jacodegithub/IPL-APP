package com.springboot.ipl.app.repository;

import com.springboot.ipl.app.entity.Team;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamByTeamName(String teamName);

    List<Team> findAll();

    @Query("SELECT t FROM Team t")
    List<Team> getTeams();
}
