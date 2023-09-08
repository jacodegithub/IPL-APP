import React, { useEffect, useState } from 'react'
import { HelperFunctionForAllMatches, HelperFunctionGetAllSeasons, HelperFunctionToGetMatchesBySeason } from '../../service/Helper'
import { useParams } from 'react-router-dom'
import { MatchDetailCard } from '../../components/matchDataCard/matchDetailCard'
import '../../components/matchDataCard/matchDetailCard.scss'
import './matchPage.scss'

export const MatchPage = () => {

    const [matches, setMatches] = useState([])

    let { teamName } = useParams();

    const [typeTeamName, setTypeTeamName] = useState('')

    const [season, setSeason] = useState([])

    const [first, setFirst] = useState('')
    const [second, setSecond] = useState('')

 
    const handleSubmit = () => {
        console.log('years selected ->', first, second)

        // HelperFunctionToGetMatchesBySeason(first, second).then(data => {
        //     console.log('matches by year ->', data)
        // }).catch(error => {
        //     console.log('matches by year ->', error)
        // })
        HelperFunctionToGetMatchesBySeason(typeTeamName, first, second).then(data => {
            setMatches(data)
            teamName = typeTeamName
            console.log('teamname -> ', teamName)
            console.log('matches by year ->', data)
        }).catch(error => {
            console.log('matches by year ->', error)
        })
    }

    const handleTeamName = (e) => {
        setTypeTeamName(e.target.value)
    }

    useEffect(() => {
        

        HelperFunctionForAllMatches(teamName).then(data => {
            setMatches(data)
            console.log("all matches -> ", data)
        }).catch(error => {
            console.log(error)
        })

        HelperFunctionGetAllSeasons().then(data => {
            console.log('all seasons', data)
            setSeason(data)
        }).catch(error => {
            console.log('seasons ->', error);
        })

    }, [teamName, first, second])

  return (
    <div className="match-page max-width">
        <div className="match-page-header-wrapper">
            <div className="match-page-heading">
                All matches of {teamName}
            </div>
            <div className="match-page-season">
                <input type="text" placeholder='Type team name' onChange={handleTeamName}/>
                <label htmlFor='year'>Select year: Fron</label>
                <select name="year" id="year" onChange={e => setFirst(e.target.value)}>
                    {
                        season && season.map((eyr, index) => (
                            <option key={index} value={eyr}>{eyr}</option>
                        ))
                    }
                </select>
                <label htmlFor="year">To</label>
                <select name="year" id="year" onChange={e => setSecond(e.target.value)}>
                    {
                        season && season.map((eyr, index) => (
                            <option key={index} value={eyr}>{eyr}</option>
                        ))
                    }
                </select>
                <button onClick={handleSubmit}>Filter</button>
            </div>
        </div>
        <div className='match-detail-card'>
            {
                matches && matches.map((match, index) => <MatchDetailCard key={index} teamName={teamName} match={match} />)
            }
        </div>
    </div>
  )
}
