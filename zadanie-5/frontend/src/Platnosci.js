import React, { useState } from 'react';
import './App.css';

const Platnosci = () => {
  const [dane, setDane] = useState({
    kwota: '',
    produktId: ''
  });

  const handleChange = (e) => {
    setDane({
      ...dane,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch('http://localhost:8080/platnosci', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(dane)
    })
      .then(response => {
        if (response.ok) {
          alert('Płatność wysłana!');
          setDane({ kwota: '', produktId: '' });
        } else {
          alert('Błąd wysyłania płatności.');
        }
      })
      .catch(error => console.error('Błąd:', error));
  };

  return (
    <div>
      <h2>Formularz Płatności</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>
            <span>Kwota:</span>
            <input
              type="number"
              name="kwota"
              value={dane.kwota}
              onChange={handleChange}
              required
            />
          </label>
        </div>
        <div>
          <label>
            <span>ID Produktu:</span>
            <input
              type="text"
              name="produktId"
              value={dane.produktId}
              onChange={handleChange}
              required
            />
          </label>
        </div>
        <button type="submit">Wyślij płatność</button>
      </form>
    </div>
  );
};

export default Platnosci;
