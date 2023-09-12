import React, { useEffect, useState } from 'react'
import { HelperFunctionForAllMatches, HelperFunctionGetAllSeasons, HelperFunctionToGetMatchesBySeason } from '../../service/Helper'
import { useParams } from 'react-router-dom'
import { MatchDetailCard } from '../../components/matchDataCard/matchDetailCard'
import '../../components/matchDataCard/matchDetailCard.scss'
import './matchPage.scss'

export const MatchPage = () => {

    const [matches, setMatches] = useState([])

    let { teamName } = useParams();

    const [typeTeamName, setTypeTeamName] = useState(teamName)
    const [flag, setFlag] = useState(false)

    const [season, setSeason] = useState([])

    const [first, setFirst] = useState('')
    const [second, setSecond] = useState('')

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('years selected ->', first, second)

        HelperFunctionToGetMatchesBySeason(typeTeamName, first, second).then(data => {
            setMatches(data)
            console.log('teamname -> ', typeTeamName)
            console.log('matches by year ->', data)
        }).catch(error => {
            console.log('matches by year ->', error)
        })
    }

    const handleFirstSeason = (e) => {
        console.log('value ->', e.target.value)
        setFirst(e.target.value)
    }
    console.log(first)
    const handleTeamName = (e) => {
        setTypeTeamName(e.target.value)
    }

    const renderOptionYear = () => {
        return season && season?.map((yr, index) => (
            <option key={index} value={yr}>{yr}</option>
        ))
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
                All matches of {typeTeamName || teamName}
            </div>
            <div className="match-page-season">
                <form onSubmit={handleSubmit}>
                    <input type="text" placeholder='Team name' onChange={handleTeamName}/>
                    <label htmlFor="year">Select year: From</label>
                    <select name="year" id="year" onChange={(e) => handleFirstSeason(e)}>
                        {renderOptionYear()}
                    </select>
                    <label htmlFor="year">To</label>
                    <select name="year" id="year" onCanPlay={e => setSecond(e.target.value)}>
                        {renderOptionYear()}
                    </select>
                    <button type="submit">Filter</button>
                </form>
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
