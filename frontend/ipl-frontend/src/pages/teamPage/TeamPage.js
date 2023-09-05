import React, { useEffect, useState } from 'react'
import { HelperFunction } from '../../service/Helper';
import { MatchDetailCard } from '../../components/matchDataCard/matchDetailCard'
import { TeamDetailCard } from '../../components/teamDataCard/teamDetailCard'
import { useParams } from 'react-router-dom';
import './teamPage.scss'

export const TeamPage = () => {

  const [teamData, setTeamData] = useState({matches: []});

  const { teamName } = useParams();

  useEffect(() => {
    HelperFunction(teamName).then(data => {
      setTeamData(data)
      console.log('data -> ', data)
    }).catch(error => {
      console.log('error -> ',error)
    })
  }, [teamName])

  return (
    <div className="team-page max-width">
      <TeamDetailCard matches={teamData?.matches[0]} teamData={teamData} teamName={teamData.teamName} />
      <div className="match-detail-card">
      {
        teamData && teamData?.matches?.slice(1).map((match, index) => <MatchDetailCard key={index} teamName={teamData.teamName} match={match} />)
      }
      </div>
    </div>
  )
      
}
