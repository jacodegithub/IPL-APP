import { Cell, Pie, PieChart, Tooltip } from 'recharts'
import './teamPageChart.scss'

export const TeamPageChart = ({teamName, pieChartData}) => {
  
  console.log('THIS PIE -', pieChartData)

  const COLORS = [ '#00C49F', '#8884d8'];
    return (
    <div className='team-page-chart' >
        
        <PieChart width={200} height={250}>
            <Pie
                data={pieChartData}
                cx="50%"
                cy="50%"
                outerRadius={80}
                fill="#8884d8"
                dataKey="value"
                label
            >
            {pieChartData.map((entry, index) => (
                <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
            ))}
            </Pie>
            <Tooltip />
            
        </PieChart>
        <div className="team-name">{teamName}</div>
    </div>
  )
}
