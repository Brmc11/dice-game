import React, { Component } from 'react';
import Header from './components/Header'
import DiceGame from './components/DiceGame';

import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header />
        <DiceGame />
      </div>
    );
  }
}

export default App;
