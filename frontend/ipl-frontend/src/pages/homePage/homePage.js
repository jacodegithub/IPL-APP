import React, { useEffect, useState } from 'react'
import { HelperFunctionToGetAllTeams } from '../../service/Helper'
import { Teams } from './teams'
import './homePage.scss'
import { Outlet } from 'react-router-dom'

export const HomePage = () => {

    const [teams, setTeams] = useState([])

    useEffect(() => {
        HelperFunctionToGetAllTeams().then(data => {
            setTeams(data)
            console.log('home page', data)
        }).catch(error => {
            console.log('home page', error)
        })
    }, [])

  return (
    <div className='home-page max-width'>
        <h1 className='home-page-title'>IPL DATA APP</h1>
        <div className="home-page-body">
            {
                teams && teams?.map((team, index) => (<Teams key={index} team={team} />))
            }
        </div>
    </div>
  )
}
