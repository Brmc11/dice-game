import React from 'react';
import snakeeyes from '../resources/snakeeyes.svg';
import duece from '../resources/duece.svg';
import tres from '../resources/tres.svg';
import quatro from '../resources/quatro.svg';
import fiver from '../resources/fiver.svg';
import six from '../resources/six.svg';

const Header = ({}) => {
    return (
      <header className="App-header">
        <div className="App-header-container">
          <img src={snakeeyes} className="App-logo-1" alt="logo" />
          <img src={duece} className="App-logo" alt="logo" />
          <img src={tres} className="App-logo-1" alt="logo"/>
          <img src={quatro} className="App-logo" alt="logo" />
          <img src={fiver} className="App-logo-1" alt="logo" />
          <img src={six} className="App-logo" alt="logo" />


          <h1 className="App-title">DICE - GAME</h1>
        </div>
      </header>
    );
};

export default Header;
