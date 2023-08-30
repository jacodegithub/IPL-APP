package com.springboot.ipl.app.repository;

import com.springboot.ipl.app.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamByTeamName(String teamName);
}
