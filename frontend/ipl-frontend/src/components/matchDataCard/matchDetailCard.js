import React from 'react'
import './matchDetailCard.css'
import { Link } from 'react-router-dom'


export const MatchDetailCard = ({teamName, match}) => {
  if(!match) return null;

  const otherTeam = (teamName === match.team1 ? match.team2 : match.team1);

  const otherTeamLink = `/teams/${otherTeam}`;

  return (
    <div className='max-width'>
      <div className="match-detail-card">
        <Link to={otherTeamLink}>VS {otherTeam}</Link>
      </div>
    </div>
  )
}
