import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import Member from './pages/Member'
const App = () => {
 
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<Home  />} />
          <Route path="/member" element={<Member  />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
