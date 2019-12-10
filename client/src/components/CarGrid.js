import React from 'react';

const CarGrid = ({cars, handleSelect}) => (
  Array.isArray(cars) ? 
    <div className="cars-container">
      <div className="cards-container">
        {
          cars.map(car => (
            <div className="car-card" key={car.vin} onClick={() => { handleSelect(car) }}>
              <div className="car-photo">
                { car.media.photo_links.length > 0 ? <img src={car.media.photo_links[0]} alt={car.build.make} /> : <p>No Photos</p> }
              </div>
              <div>Make/Model: { car.build.make + " " + car.build.model}</div>
              <div>Year: {car.build.year }</div>
              <div>Engine: {car.build.engine }</div>
              <div>Color: { car.exterior_color }</div>
              <div>Mileage: {car.miles} </div>
            </div>))
        }
      </div>
    </div> : 
    null
);

export default CarGrid;
