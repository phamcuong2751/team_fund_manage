import React from 'react';

const Home = ({ expenses, total }) => {
  return (
    <div>
      <h2>Chi Tiết Chi Tiêu</h2>
      <ul>
        {expenses.map((expense, index) => (
          <li key={index}>
            {expense.name}: {expense.amount} VNĐ
          </li>
        ))}
      </ul>
      <h3>Tổng Chi Tiêu: {total} VNĐ</h3>
      <a href="/add-expense">Thêm Chi Tiêu</a>
    </div>
  );
};

export default Home;
