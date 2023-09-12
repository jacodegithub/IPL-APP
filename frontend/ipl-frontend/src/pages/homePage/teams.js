import React from 'react'
import './teams.scss'
import { Link } from 'react-router-dom'

export const Teams = ({team}) => {
    if(!team) return null

    const clickedTeam = `/teams/${team.teamName}`;
  return (
    <Link to={clickedTeam}>
        <div className='each-team pointer'>
            <h2 className='team-name'>{team.teamName}</h2>
            <h4 className='team-short-name'>{team.shortName}</h4>
            <h4 className='team-matches'>Total Matches: {team.totalMatches}</h4>
            <h4 className='team-wins'>Total Wins: {team.totalWins}</h4>
        </div>
    </Link>
  )
}
