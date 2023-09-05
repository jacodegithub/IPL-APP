package com.springboot.ipl.app.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private String shortName;
    private Long totalMatches;
    private Long totalWins;

    @Transient
    private List<Match> matches;

    public Team() {
    }

    public Team(String teamName,Long totalMatches) {
        this.teamName = teamName;
        this.totalMatches = totalMatches;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Long totalMatches) {
        this.totalMatches = totalMatches;
    }

    public Long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(Long totalWins) {
        this.totalWins = totalWins;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
