import React, { useEffect, useState } from 'react'
import { HelperFunctionForAllMatches } from '../../service/Helper'
import { useParams } from 'react-router-dom'
import { MatchDetailCard } from '../../components/matchDataCard/matchDetailCard'
import '../../components/matchDataCard/matchDetailCard.scss'

export const MatchPage = () => {

    const [matches, setMatches] = useState([])

    const { teamName } = useParams();

    useEffect(() => {

        HelperFunctionForAllMatches(teamName).then(data => {
            setMatches(data)
            console.log("all matches -> ", data)
        }).catch(error => {
            console.log(error)
        })

    }, [teamName])

  return (
    <div className="match-page max-width">
        <div className="match-page-heading">
            {teamName}
        </div>
        <div className='match-detail-card'>
            {
                matches && matches.map((match, index) => <MatchDetailCard key={index} teamName={teamName} match={match} />)
            }
        </div>
    </div>
  )
}
