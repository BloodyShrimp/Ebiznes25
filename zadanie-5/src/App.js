import React from 'react';
import Produkty from './Produkty';
import Platnosci from './Platnosci';
import './App.css';

function App() {
  return (
    <div className="container">
      <h1>Sklep Internetowy</h1>
      <Produkty />
      <Platnosci />
    </div>
  );
}

export default App;
