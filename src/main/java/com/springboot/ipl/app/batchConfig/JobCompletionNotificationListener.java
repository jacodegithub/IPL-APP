package com.springboot.ipl.app.batchConfig;

import com.springboot.ipl.app.entity.Match;
import com.springboot.ipl.app.entity.Team;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

  private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

  private final EntityManager em;

  @Autowired
  public JobCompletionNotificationListener(EntityManager em) {
    this.em = em;
  }

  @Override
    @Transactional
  public void afterJob(JobExecution jobExecution) {
    if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
      log.info("!!! JOB FINISHED! Time to verify the results");

      Map<String, Team> teamData = new HashMap<>();

      // FOR TEAM 01
      em.createQuery("select m.team1, count(*) from Match m where team1 != '' group by m.team1", Object[].class)
              .getResultList()
              .forEach(t -> {
                Team teamObj = new Team((String) t[0], (Long) t[1]);
                teamData.put((String) t[0], teamObj);
              });

      // FOR TEAM 02
      em.createQuery("select m.team2, count(*) from Match m group by m.team2", Object[].class)
              .getResultList()
              .forEach(t -> {
                Team teamObj = teamData.get((String) t[0]);
                if(teamObj != null) teamObj.setTotalMatches(teamObj.getTotalMatches() + (Long) t[1]);
              });


      // FOR MATCH WINNER COUNT
      em.createQuery("SELECT m.matchWinner, COUNT(*) FROM Match m GROUP BY m.matchWinner"
                      , Object[].class)
              .getResultList()
              .forEach(t -> {
                      Team team = teamData.get((String) t[0]);
                      String teamName = team.getTeamName();
                  if(teamName != null) {
                      team.setTotalWins((Long) t[1]);
                  }
              });

      // FOR SHORT NAME OF TEAM
        em.createQuery("SELECT m.teamOneShortName, m.team1 FROM Match m WHERE m.team1 != '' GROUP BY m.teamOneShortName, m.team1", Object[].class)
                .getResultList()
                .forEach(t -> {
                    Team teamObj = teamData.get((String) t[1]);
                    teamObj.setShortName((String) t[0]);
                });

      teamData.values().forEach(data -> em.persist(data));
    }
  }
}
