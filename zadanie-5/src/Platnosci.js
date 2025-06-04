import React, { useState } from 'react';

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

    fetch('http://localhost:8080/platnosci', { // zmień na adres swojego backendu
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
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
          <label>Kwota:</label>
          <input
            type="number"
            name="kwota"
            value={dane.kwota}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label>ID Produktu:</label>
          <input
            type="text"
            name="produktId"
            value={dane.produktId}
            onChange={handleChange}
            required
          />
        </div>
        <button type="submit">Wyślij płatność</button>
      </form>
    </div>
  );
};

export default Platnosci;
