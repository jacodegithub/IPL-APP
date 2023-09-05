
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import { TeamPage } from "./pages/teamPage/TeamPage";

function App() {
  return (
    <div className="App">
      <header className="App-container">
        <Router>
          <Routes>
            <Route path='/teams/:teamName' element={<TeamPage />} />
          </Routes>
        </Router>
      </header>
    </div>
  );
}

export default App;
