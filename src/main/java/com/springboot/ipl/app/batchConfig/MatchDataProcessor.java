package com.springboot.ipl.app.batchConfig;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.springboot.ipl.app.dto.MatchData;
import com.springboot.ipl.app.entity.Match;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
public class MatchDataProcessor implements ItemProcessor<MatchData, Match> {


  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);


  @Override
  public Match process(MatchData matchData) throws Exception {
    Match match = new Match();

//    if(match != null) {
//      return match;
//    }

    match.setId(Long.parseLong(matchData.getId()));
    match.setSeason(matchData.getSeason());

//    log.info("Converting (" + matchData + ") into (" + match + ")");

    // SETTING TEAM1 AND TEAM2 ACCORDING TO TOSS WINNER
    Map<String, String> team1 = new HashMap<>();
    Map<String, String> team2 = new HashMap<>();

    String[] teamName = matchData.getName().split(" v ");
    String[] shortNames = matchData.getShort_name().split(" v ");

    team1.put(shortNames[0], teamName[0]);
    team2.put(shortNames[1], teamName[1]);

//    System.out.println(Arrays.toString(teamName)+" "+Arrays.toString(shortNames));
//    System.out.println(Arrays.toString(shortNames));
    match.setDescription(matchData.getDescription());

    String tossWinner = matchData.getToss_won();
    String decision = matchData.getDecision();
//    System.out.println(tossWinner);
    match.setTossWinner((tossWinner.equals(shortNames[0]) ? team1.get(shortNames[0]) : team2.get(shortNames[1])));
    match.setDecision(matchData.getDecision().equals("") ? "" : matchData.getDecision());

    String firstInningsTeam = "", secondInningsTeam = "";
    if(!tossWinner.equals("") && !decision.equals("")) {
      if(decision.equals("BAT")) {
        match.setTeamOneShortName(tossWinner.equals(shortNames[0]) ? shortNames[0] : shortNames[1]);
        match.setTeamTwoShortName(tossWinner.equals(shortNames[0]) ? shortNames[1] : shortNames[0]);
        firstInningsTeam = tossWinner.equals(shortNames[0]) ? team1.get(shortNames[0]) : team2.get(shortNames[1]);
        secondInningsTeam = firstInningsTeam.equals(teamName[0]) ? teamName[1] : teamName[0];

      }
      else {
        match.setTeamOneShortName(tossWinner.equals(shortNames[0]) ? shortNames[1] : shortNames[0]);
        match.setTeamTwoShortName(tossWinner.equals(shortNames[0]) ? shortNames[0] : shortNames[1]);
        firstInningsTeam = tossWinner.equals(shortNames[0]) ? team2.get(shortNames[1]) : team1.get(shortNames[0]);
        secondInningsTeam = firstInningsTeam.equals(teamName[0]) ? teamName[1] : teamName[0];
//        System.out.println(firstInningsTeam+" "+secondInningsTeam);
      }
    }
    // END
//    System.out.println(firstInningsTeam+" "+secondInningsTeam);
    match.setTeam1(firstInningsTeam.equals("") ? "" : firstInningsTeam);
    match.setTeam2(secondInningsTeam.equals("") ? "" : secondInningsTeam);

//    log.info("decisions: {}", matchData.getDecision(), match.getDecision());
    match.setFirstInningScore(matchData.getFirst_inning_score());
    match.setSecondInningScore(matchData.getSecond_inning_score());
    match.setMatchWinner(matchData.getWinner().equals(shortNames[0]) ? team1.get(shortNames[0]) : team2.get(shortNames[1]));
    match.setResult(matchData.getResult());

    //CONVERTING STRING DATE TO DATE
    match.setStartDate(dateManipulation(matchData.getStart_date()));
    match.setEndDate(dateManipulation(matchData.getEnd_date()));

    match.setVenueName(matchData.getVenue_name());
    match.setHomeCaptain(matchData.getHome_captain());
    match.setSuperOver(matchData.getSuper_over());
    match.setHomeOvers(Double.parseDouble(matchData.getHome_overs().equals("") ? "0.0" : matchData.getHome_overs()));
    match.setHomeRuns(Long.parseLong(matchData.getHome_runs().equals("") ? "0" : matchData.getHome_runs()));
    match.setHomeWickets(Long.parseLong(matchData.getHome_wickets().equals("") ? "0" : matchData.getHome_wickets()));
    match.setHomeBoundaries(Long.parseLong(matchData.getHome_boundaries().equals("") ? "0" : matchData.getHome_boundaries()));
    match.setHighlights(matchData.getHighlights());
    match.setHomeKeyBatsman(matchData.getHome_key_batsman());
    match.setHomeKeyBowler(matchData.getHome_key_bowler());
    match.setHomePlayx1(matchData.getHome_playx1());
    match.setMatchDays(matchData.getMatch_days());
    match.setUmpire1(matchData.getUmpire1());
    match.setUmpire2(matchData.getUmpire2());
    match.setTvUmpire(matchData.getTv_umpire());
    match.setReferee(matchData.getReferee());
    match.setReserveUmpire(matchData.getReserve_umpire());

    return match;
  }

  public Date dateManipulation(String format) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
    Date date;
    try {
      date = dateFormat.parse(format);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }

    return date;
  }

//  public void testing() {
//    Field[] matchFields = Match.class.getDeclaredFields();
//
//    log.info("season -> : {}", match.getSeason());
//
//    for (Field field : matchFields) {
//      String fieldName = field.getName();
//      String getterName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//
//      try {
//        // Get the value of the field from the Match object using reflection
//        Method getterMethod = Match.class.getMethod(getterName);
//        Object value = getterMethod.invoke(match);
//
//        // Print the field name and its value
////        System.out.println(fieldName + ": " + value);
//        log.info("firstName, value: {}",fieldName, value);
//      } catch (Exception e) {
//        // Handle exceptions if needed
//        e.printStackTrace();
//      }
//    }
//  }
}
