import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import AddExpense from './pages/AddExpense';

const App = () => {
  const [expenses, setExpenses] = useState([]);
  const [total, setTotal] = useState(0);

  const addExpense = (expense) => {
    setExpenses([...expenses, expense]);
    setTotal(total + expense.amount);
  };

  return (
    <Router>
      <div>
        <h1>Quản Lý Tiền Quỹ Nhóm</h1>
        <Routes>
          <Route path="/" element={<Home expenses={expenses} total={total} />} />
          <Route path="/add-expense" element={<AddExpense addExpense={addExpense} />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
