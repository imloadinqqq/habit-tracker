import React, { useState, useEffect } from 'react';

function App() {
  const [habits, setHabits] = useState([]);
  const [error, setError] = useState(null);
  const [data, setData] = useState({});

  useEffect(() => {
    fetch('http://localhost:8080/api/habits')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Failed to fetch habits');
        }
        return response.json();
      })
      .then((data) => setHabits(data))
      .catch((error) => setError(error.message));
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/api/habits', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const responseData = await response.json();
      console.log(responseData);
      setHabits((prevHabits) => [...prevHabits, responseData]);
    } catch (error) {
      console.error('Error:', error);
    }
  };

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/api/habits/${id}`, {
        method: 'DELETE',
      });

      if (!response.ok) {
        throw new Error('Failed to delete habit');
      }

      setHabits((prevHabits) => prevHabits.filter((habit) => habit.id !== id));
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div>
      <h1>Habits Tracker</h1>
      {error ? (
        <p style={{ color: 'red' }}>{error}</p>
      ) : (
        <ul>
          {habits.map((habit) => (
            <li key={habit.id}>
              <strong>{habit.name}</strong>: {habit.description}{' '}
              <button onClick={() => handleDelete(habit.id)}>Delete</button>
            </li>
          ))}
        </ul>
      )}
      <form onSubmit={handleSubmit}>
        <label>
          Name:
          <input
            type="text"
            value={data.name || ''}
            onChange={(e) => setData({ ...data, name: e.target.value })}
          />
        </label>
        <br />
        <label>
          Description:
          <input
            type="text"
            value={data.description || ''}
            onChange={(e) => setData({ ...data, description: e.target.value })}
          />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
