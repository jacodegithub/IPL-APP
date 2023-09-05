import React, { useEffect, useState } from 'react'
import { MatchDetailCard } from '../components/matchDataCard/matchDetailCard'
import { TeamDetailCard } from '../components/teamDataCard/teamDetailCard'
import { HelperFunction } from '../service/Helper';
import { useParams } from 'react-router-dom';

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
    <div>
      <div className="team-home-page">
        <TeamDetailCard matches={teamData?.matches[0]} teamData={teamData} teamName={teamData.teamName} />
        {
          teamData && teamData?.matches?.slice(1).map((match, index) => <MatchDetailCard key={index} teamName={teamData.teamName} match={match} />)
        }
        
      </div>
    </div>
  )
}
