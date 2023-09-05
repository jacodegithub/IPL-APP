import React, { useEffect, useState } from 'react'
import './teamDetailCard.css'

export const TeamDetailCard = ({matches, teamData, teamName}) => {
  if(!teamData || !matches) return null;
  return (
    <div className='max-width'>
      <div className="team-card">
        {
          teamData && (
            <div key={teamData.id}>
              <h1>{teamName}</h1>
              <h2>{teamData.shortName}</h2>
              <h2>VS {matches.team2}</h2>
              <h3>Total Matches : {teamData.totalMatches}</h3>
              <h3>Total Wins : {teamData.totalWins}</h3>
            </div>            
          )
        }
      </div>
    </div>
  )
}
