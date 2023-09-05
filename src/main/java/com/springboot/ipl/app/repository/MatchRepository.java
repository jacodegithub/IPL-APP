package com.springboot.ipl.app.repository;

import com.springboot.ipl.app.entity.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findMatchByTeam1OrTeam2OrderByStartDateDesc(String team1, String team2, Pageable pages);

    List<Match> findMatchByTeam1OrTeam2(String team1, String team2);

}
