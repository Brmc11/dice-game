import React from 'react';
// import memoizeOne from 'memoize-one';
import GameBoard from './GameBoard';
import CarForm from './CarForm'; 
import CarGrid from './CarGrid'; 
import SelectedCar from './SelectedCar'; 
import Button from '@material-ui/core/Button';
import './DiceGame.css';

const defaultState = {
  isLoading: false,
  userInput: {},
  cars: [],
  selectedCar: {},
  areNoSearchResults: false
};

class DiceGame extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      ...defaultState
    };
    
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleSelect = this.handleSelect.bind(this);
  }

  determineIfSearchResults(){
   const areNoSearchResults = Object.keys(this.state.userInput).length > 0 && this.state.cars.length === 0;
   this.setState({
    areNoSearchResults
   });
  }
  
  handleSelect(car) {
    this.setState({ selectedCar: car });
  }
  
  handleSubmit(userInput) {
    this.setState({
      userInput,
      isLoading: true
    });
    
    console.log('>>>> USER INPUT: ', userInput);

    const { make, model, year, radius, zipCode } = userInput;

    fetch(`http://localhost:8080/search?make=${make}&model=${model}&year=${year}&radius=${radius}&zipCode=${zipCode}`)
    .then(response => response.json())
    .then(data => this.setState({ cars: data, isLoading: false }))
    .then(() => {
      this.determineIfSearchResults();
    }).catch((error) => console.error('Error: ', error));
  }
  
  handleReset = () => {
    this.setState({
      ...defaultState
    });
  }; 

  render() {
    const { isLoading, cars, selectedCar } = this.state;
    return (
      <div className="game-container">
        <Button variant="outlined" color="secondary" onClick={this.handleReset} >
          Start Over
        </Button>
        {
          cars.length === 0 ?
          <div className="form-container">
            <CarForm handleSubmit={this.handleSubmit} areNoSearchResults={this.state.areNoSearchResults} />
          </div> :
          <div>

            { isLoading && <p> Loading </p> }

            {
              Object.keys(selectedCar).length === 0 ?
              <CarGrid
                cars={cars}
                handleSelect={this.handleSelect}
              /> :
              <React.Fragment>
                <SelectedCar car={selectedCar}/>
                <GameBoard />
              </React.Fragment>
            }
          </div>
        }
      </div>

    )
  }
}

export default DiceGame;
