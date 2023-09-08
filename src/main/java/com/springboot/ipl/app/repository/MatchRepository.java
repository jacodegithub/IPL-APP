package com.springboot.ipl.app.repository;

import com.springboot.ipl.app.entity.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findMatchByTeam1OrTeam2OrderByStartDateDesc(String team1, String team2, Pageable pages);

    List<Match> findMatchByTeam1OrTeam2(String team1, String team2);

    // @Query("SELECT m.season FROM Match m GROUP BY season")
    // List<String> findAllSeason();
    @Query("SELECT DISTINCT m.season FROM Match m")
    List<String> findAllSeason();

    // @Query("SELECT m.team1, m.team2 FROM Match m "
    // +" WHERE CAST(m.season AS Integer) BETWEEN (:first AND :second)")
    // Optional<Match> findMatchesBetweenSeasons(String team1, String team2, 
    //                                         @Param("first") String firstSeason, @Param("second") String second);

    // @Query("SELECT m.team1, m.team2 FROM Match m WHERE m.season BETWEEN (:first AND :second)")
    // Optional<Object[]> findMatchesBySeason(@Param("first") String firstSeason, @Param("second") String secondSeason);

    List<Match> findMatchBySeasonBetween(String seasonFirst, String seasonSecond);

    // List<Match> findMatchByTeam1OrTeam2AndSeasonBetween(String team1, String team2, String firstSeason, String secondSeason);

    @Query("SELECT m FROM Match m WHERE (m.team1 = :team OR m.team2 = :team) AND m.season BETWEEN :startSeason AND :endSeason")
    List<Match> findMatchesByTeamAndSeasonBetween(@Param("team") String team, @Param("startSeason") String startSeason, @Param("endSeason") String endSeason);

}
