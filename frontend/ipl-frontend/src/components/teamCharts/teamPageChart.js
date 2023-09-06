import { Cell, Pie, PieChart, Tooltip } from 'recharts'

export const TeamPageChart = ({teamName, pieChartData}) => {
  
  console.log('THIS PIE -', pieChartData)

  const COLORS = [ '#00C49F', '#FF8042'];
    return (
    <div className='team-page-chart' style={{display:'flex', flexDirection:'column', justifyContent:'center'}}>
        
            <PieChart width={200} height={200}>
                <Pie
                    data={pieChartData}
                    cx="50%"
                    cy="50%"
                    outerRadius={70}
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
        <div className="team-name" style={{alignSelf:'center', color:'white'}}>{teamName}</div>
    </div>
  )
}
