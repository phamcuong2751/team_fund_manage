import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Member from './pages/Member'
const App = () => {
 
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/home" element={<Home  />} />
          <Route path="/" element={<Member  />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
