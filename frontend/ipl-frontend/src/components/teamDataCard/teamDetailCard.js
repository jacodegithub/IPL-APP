import './teamDetailCard.scss'
import '../../components/matchDataCard/matchDetailCard.scss'

export const TeamDetailCard = ({matches, teamData, teamName}) => {
  if(!teamData || !matches) return null;

  const otherTeam = (teamName === matches.team2 ? matches.team1 : matches.team2);

  return (
    <div className='team-card max-width'>      
        {
          teamData && (
            <div key={teamData.id} className='team-name-container'>
                <div className="team-name-wrapper">
                  <div className='team-name'>{teamName}</div>
                  <div className='team-short-name'>{teamData.shortName}</div>
                </div>
                <div className="team-chart">
                  <div>
                    pie chart
                  </div>
                </div>
                <div className={`team-details ${otherTeam === teamName ? `match-winner` : `match-looser`}`}>
                  <div className="match-details-left">
                    <div className='team-vs'>VS {otherTeam}</div>
                    <div className="match-time">Time: {matches.matchDays}</div>
                    <div className="match-venue">Venue: {matches.venueName}</div>
                    <div className="match-highlights">Hightlights: {matches.highlights}</div>
                    
                  </div>
                  <div className='match-details-right'>
                    <div className="match-captain">Captain: {matches.homeCaptain}</div>
                    <div className="firstInningScore">First Innings Score: {matches.firstInningScore}</div>
                    <div className="secondInningScore">Second Innings Score: {matches.secondInningScore}</div>
                    <div className="match-umpire">Umpire: {matches.reserveUmpire}</div>
                    
                  </div>
                </div>
            </div>            
          )
        }
    </div>
  )
}
