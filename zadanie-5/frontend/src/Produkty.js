import React, { useEffect, useState } from 'react';
import './App.css';

const Produkty = () => {
  const [produkty, setProdukty] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/produkty')
      .then(response => response.json())
      .then(data => setProdukty(data))
      .catch(error => console.error('Błąd pobierania produktów:', error));
  }, []);

  return (
    <div>
      <h2>Lista Produktów</h2>
      <ul>
        {produkty.map((produkt) => (
          <li key={produkt.id}>ID: {produkt.id} - {produkt.nazwa} - {produkt.cena} PLN</li>
        ))}
      </ul>
    </div>
  );
};

export default Produkty;
