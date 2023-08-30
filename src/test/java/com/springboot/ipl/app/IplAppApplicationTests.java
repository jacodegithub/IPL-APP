package com.springboot.ipl.app;

import com.springboot.ipl.app.batchConfig.MatchDataProcessor;
import com.springboot.ipl.app.dto.MatchData;
import com.springboot.ipl.app.entity.Match;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class IplAppApplicationTests  {

	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	@Test
	void contextLoads() {
	}
	@Test
	public void process() throws Exception {
		Match match = new Match();
		MatchData matchData = new MatchData();
//		match.setId(Long.parseLong(matchData.getId()));
//		match.setSeason(matchData.getSeason());
//
//		// SETTING TEAM1 AND TEAM2 ACCORDING TO TOSS WINNER
//		Map<String, String> team1 = new HashMap<>();
//		Map<String, String> team2 = new HashMap<>();
//
//		String[] teamName = matchData.getName().split(" v ");
//
//		String[] shortNames = matchData.getShort_name().split(" v ");
//
//		team1.put(teamName[0], shortNames[0]);
//		team2.put(teamName[1], shortNames[1]);
//
//
//		match.setDescription(matchData.getDescription());
//		match.setTossWinner((matchData.getToss_won() == shortNames[0] ? team1.get(shortNames[0]) : team2.get(shortNames[1])));
//
//		match.setTeam1ShortName((matchData.getToss_won() == shortNames[0] ? shortNames[0] : shortNames[1]));
//		match.setTeam2ShortName((matchData.getToss_won() != shortNames[0] ? shortNames[0] : shortNames[1]));
//
//		String firstInningsTeam, secondInningsTeam;
//		firstInningsTeam = matchData.getToss_won().equals(shortNames[0]) ?
//				team1.get(shortNames[0]) : team2.get(shortNames[1]) ;
//		secondInningsTeam = firstInningsTeam.equals(team1.get(shortNames[0])) ?
//				team1.get(shortNames[0]) : team2.get(shortNames[1]) ;
//
//		// END
//
//		match.setTeam1(firstInningsTeam);
//		match.setTeam2(secondInningsTeam);
//
//		match.setDecision(matchData.getDecision());
//		log.info("decisions: {}", matchData.getDecision(), match.getDecision());
//		match.setFirstInningScore(matchData.getFirst_inning_score());
//		match.setSecondInningScore(matchData.getSecond_inning_score());
//		match.setMatchWinner(matchData.getWinner());
//		match.setResult(matchData.getResult());
	}
}
