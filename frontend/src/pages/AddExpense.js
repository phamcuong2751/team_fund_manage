import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate instead of useHistory

const AddExpense = ({ addExpense }) => {
  const [name, setName] = useState('');
  const [amount, setAmount] = useState('');
  const navigate = useNavigate(); // Use useNavigate hook

  const handleSubmit = (e) => {
    e.preventDefault();
    addExpense({ name, amount: parseFloat(amount) });
    navigate('/'); // Navigate back to home after adding expense
  };

  return (
    <div>
      <h2>Thêm Chi Tiêu</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Tên Chi Tiêu:</label>
          <input 
            type="text" 
            value={name} 
            onChange={(e) => setName(e.target.value)} 
            required 
          />
        </div>
        <div>
          <label>Số Tiền:</label>
          <input 
            type="number" 
            value={amount} 
            onChange={(e) => setAmount(e.target.value)} 
            required 
          />
        </div>
        <button type="submit">Thêm</button>
      </form>
      <a href="/">Quay lại</a>
    </div>
  );
};

export default AddExpense;
