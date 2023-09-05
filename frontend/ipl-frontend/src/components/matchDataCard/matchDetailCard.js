import React from 'react'
import './matchDetailCard.scss'
import { Link } from 'react-router-dom'


export const MatchDetailCard = ({teamName, match}) => {
  if(!match) return null;

  const otherTeam = (teamName === match.team1 ? match.team2 : match.team1);

  const otherTeamLink = `/teams/${otherTeam}`;

  return (
    <div className='match-card'>
      <div className="match-card-left">
        <div className={match.matchWinner === teamName ? "match-winner" : "match-looser"}>
          <Link to={otherTeamLink}>VS {otherTeam}</Link>
        </div>
        {/* <div className={match.matchWinner === teamName ? "match-winner" : "match-looser"}>{match.matchWinner}</div> */}
        <div className="match-card-captain">c. {match.homeCaptain}</div>
        <div className="match-card-venue-name">{match.venueName}</div>
      </div>
      <div className="match-card-right">
        more
      </div>
    </div>
  )
}
