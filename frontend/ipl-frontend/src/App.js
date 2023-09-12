
import { Outlet, Route, BrowserRouter as Router, Routes, useLocation } from "react-router-dom";
import { TeamPage } from "./pages/teamPage/TeamPage";
import { MatchPage } from "./pages/matchPage/matchPage";
import { HomePage } from "./pages/homePage/homePage";

function App() {

  const location = useLocation();
  console.log('pathname', location)
  return (
    <div className="App">
      <header className="App-container">
        {location.pathname === "/" ? <HomePage /> : null}
   
          <Routes>
            <Route path="/" element={<Outlet />}>
              <Route path='/teams/:teamName' element={<TeamPage />} />
              <Route path='/teams/matches/:teamName' element={<MatchPage />} />
            </Route>
          </Routes>

      </header>
    </div>
  );
}

export default App;
