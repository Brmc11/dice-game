import React from 'react';
import Button from '@material-ui/core/Button'; 
import './Gameboard.css'; 

const GameBoard = (props) => {
  return (
    <div className="GameBoard">
      <div className="controls">
        <div className="die-roller">
          <div className="dice-square">7</div>
          <div>
            <Button
              variant="contained"
              color="primary"
              type="submit"
            >
              ROLL!
            </Button>

          </div>
        </div>
        <div className="higher-lower-buttons">
          <Button variant="contained"
            color="secondary"
            type="submit" 
          >
            Higher 
          </Button>
          <Button variant="contained"
            color="secondary"
            type="submit" 
          >
            Lower 
          </Button>

        </div>
      </div>
      <div className="logo"></div>
      <div className="first-digit">
        <div className="price-square price-first"></div>
      </div>
      <div className="high-price">
        <div className="price-square"></div>
        <div className="price-square"></div>
        <div className="price-square"></div>
        <div className="price-square"></div>
      </div>
      <div className="dice">
        <div className="dice-square"></div>
        <div className="dice-square"></div>
        <div className="dice-square"></div>
        <div className="dice-square"></div>
      </div>
      <div className="low-price">
        <div className ="price-square"></div>
        <div className ="price-square"></div>
        <div className ="price-square"></div>
        <div className ="price-square"></div>
      </div>
    </div>
  )
};

export default GameBoard;
