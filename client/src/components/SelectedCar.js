import React from 'react';
import './SelectedCar.css';

const SelectedCar = ({car}) => {
  const { miles, exterior_color } = car;
  const { make, model, year, engine } = car.build;
  return (
    <div className="selected-car">
      <div className="image-container">
        { car.media.photo_links.length > 0 ?
          <img src={car.media.photo_links[0]} alt={make} /> :
          <p>No Photos</p> }
        </div>
        <div className="car-details">
          <div>Make/Model: { make + " " + model }</div>
          <div>Year: { year }</div>
          <div>Engine: { engine }</div>
          <div>Color: { exterior_color }</div>
          <div>Mileage: {miles} </div>
        </div>
      </div>
  );
};

export default SelectedCar;
