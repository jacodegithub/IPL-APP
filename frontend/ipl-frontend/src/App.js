
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import { TeamPage } from "./pages/teamPage/TeamPage";
import { MatchPage } from "./pages/matchPage/matchPage";

function App() {
  return (
    <div className="App">
      <header className="App-container">
        <Router>
          <Routes>
            <Route path='/teams/:teamName' element={<TeamPage />} />
            <Route path='/teams/matches/:teamName' element={<MatchPage />} />
          </Routes>
        </Router>
      </header>
    </div>
  );
}

export default App;
