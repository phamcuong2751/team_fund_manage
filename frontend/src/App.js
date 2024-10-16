import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import MyScheduler from './pages/MyScheduler';

const App = () => {
 
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<Home  />} />
          <Route path="/scheduler" element={<MyScheduler  />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
