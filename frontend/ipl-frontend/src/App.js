import { TeamPage } from "./pages/TeamPage";
import { Route, BrowserRouter as Router, Routes } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <header className="App-header">
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
