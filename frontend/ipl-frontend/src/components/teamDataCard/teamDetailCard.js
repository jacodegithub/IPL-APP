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
                    <div className='team-vs'><span>VS</span> {otherTeam}</div>
                    <div className="match-left-title">Time: </div>
                    <div className="match-left-res">{matches.matchDays}</div>
                    <div className="match-left-title">Heighlights: </div>
                    <div className="match-left-res">{matches.highlights}</div>
                    
                  </div>
                  <div className='match-details-right'>
                    <div className="match-detail-title">Captain:</div>
                    <div className="match-detail-res">{matches.homeCaptain}</div>
                    <div className="match-detail-title">First Innings Score: </div>
                    <div className="match-detail-res">{matches.firstInningScore}</div>
                    <div className="match-detail-title">Second Innings Score: </div>
                    <div className="match-detail-res">{matches.secondInningScore}</div>
                    <div className="match-detail-title">Umpire: </div>
                    <div className="match-detail-res">{matches.reserveUmpire}</div>
                    <div className="match-detail-title">Venue: </div>
                    <div className="match-detail-res">{matches.venueName}</div>
                  </div>
                </div>
            </div>            
          )
        }
    </div>
  )
}
