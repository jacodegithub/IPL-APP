package com.springboot.ipl.app.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "season")
    private String season;
    private String team1;
    private String team2;
    private String teamOneShortName;
    private String teamTwoShortName;
    private String description;
    private String tossWinner;
    private String decision;
    private String firstInningScore;
    private String secondInningScore;
    private String matchWinner;
    private String result;
    private Date startDate;
    private Date endDate;
    private String venueName;
    private String homeCaptain;
    private String superOver;
    private Double homeOvers;
    private Long homeRuns;
    private Long homeWickets;
    private Long homeBoundaries;
    @Column(columnDefinition = "TEXT")
    private String highlights;
    private String homeKeyBatsman;
    private String homeKeyBowler;
    @Column(columnDefinition = "TEXT")
    private String homePlayx1;
    private String matchDays;
    private String umpire1;
    private String umpire2;
    private String tvUmpire;
    private String referee;
    private String reserveUmpire;

    public Match() {}

    public String getTeam1() {
        return team1;
    }



    public void setTeam1(String team1) {
        this.team1 = team1;
    }



    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeamOneShortName() {
        return teamOneShortName;
    }

    public void setTeamOneShortName(String team1ShortName) {
        this.teamOneShortName = team1ShortName;
    }

    public String getTeamTwoShortName() {
        return teamTwoShortName;
    }

    public void setTeamTwoShortName(String teamTwoShortName) {
        this.teamTwoShortName = teamTwoShortName;
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public String getSeason() {
        return season;
    }



    public void setSeason(String season) {
        this.season = season;
    }


    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }


    public String getTossWinner() {
        return tossWinner;
    }



    public void setTossWinner(String tossWinner) {
        this.tossWinner = tossWinner;
    }



    public String getDecision() {
        return decision;
    }



    public void setDecision(String decision) {
        this.decision = decision;
    }



    public String getFirstInningScore() {
        return firstInningScore;
    }



    public void setFirstInningScore(String firstInningScore) {
        this.firstInningScore = firstInningScore;
    }



    public String getSecondInningScore() {
        return secondInningScore;
    }



    public void setSecondInningScore(String secondInningScore) {
        this.secondInningScore = secondInningScore;
    }



    public String getMatchWinner() {
        return matchWinner;
    }



    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }



    public String getResult() {
        return result;
    }



    public void setResult(String result) {
        this.result = result;
    }



    public Date getStartDate() {
        return startDate;
    }



    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }



    public Date getEndDate() {
        return endDate;
    }



    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



    public String getVenueName() {
        return venueName;
    }



    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }



    public String getHomeCaptain() {
        return homeCaptain;
    }



    public void setHomeCaptain(String homeCaptain) {
        this.homeCaptain = homeCaptain;
    }



    public String getSuperOver() {
        return superOver;
    }



    public void setSuperOver(String superOver) {
        this.superOver = superOver;
    }



    public Double getHomeOvers() {
        return homeOvers;
    }



    public void setHomeOvers(Double homeOvers) {
        this.homeOvers = homeOvers;
    }



    public Long getHomeRuns() {
        return homeRuns;
    }



    public void setHomeRuns(Long homeRuns) {
        this.homeRuns = homeRuns;
    }



    public Long getHomeWickets() {
        return homeWickets;
    }



    public void setHomeWickets(Long homeWickets) {
        this.homeWickets = homeWickets;
    }



    public Long getHomeBoundaries() {
        return homeBoundaries;
    }



    public void setHomeBoundaries(Long homeBoundaries) {
        this.homeBoundaries = homeBoundaries;
    }



    public String getHighlights() {
        return highlights;
    }



    public void setHighlights(String highlights) {
        this.highlights = highlights;
    }



    public String getHomeKeyBatsman() {
        return homeKeyBatsman;
    }



    public void setHomeKeyBatsman(String homeKeyBatsman) {
        this.homeKeyBatsman = homeKeyBatsman;
    }



    public String getHomeKeyBowler() {
        return homeKeyBowler;
    }



    public void setHomeKeyBowler(String homeKeyBowler) {
        this.homeKeyBowler = homeKeyBowler;
    }



    public String getHomePlayx1() {
        return homePlayx1;
    }



    public void setHomePlayx1(String homePlayx1) {
        this.homePlayx1 = homePlayx1;
    }



    public String getMatchDays() {
        return matchDays;
    }



    public void setMatchDays(String matchDays) {
        this.matchDays = matchDays;
    }



    public String getUmpire1() {
        return umpire1;
    }



    public void setUmpire1(String umpire1) {
        this.umpire1 = umpire1;
    }



    public String getUmpire2() {
        return umpire2;
    }



    public void setUmpire2(String umpire2) {
        this.umpire2 = umpire2;
    }



    public String getTvUmpire() {
        return tvUmpire;
    }



    public void setTvUmpire(String tvUmpire) {
        this.tvUmpire = tvUmpire;
    }



    public String getReferee() {
        return referee;
    }



    public void setReferee(String referee) {
        this.referee = referee;
    }



    public String getReserveUmpire() {
        return reserveUmpire;
    }



    public void setReserveUmpire(String reserveUmpire) {
        this.reserveUmpire = reserveUmpire;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", description='" + description + '\'' +
                ", tossWinner='" + tossWinner + '\'' +
                ", matchWinner='" + matchWinner + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
