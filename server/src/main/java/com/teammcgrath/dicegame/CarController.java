package com.teammcgrath.dicegame;

import com.teammcgrath.dicegame.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class CarController {


   @Autowired
    private final CarService carService;

    public CarService getCarService() {
        return carService;
    }

    public CarController(CarService carService){
        this.carService = carService;
    }


    @RequestMapping(path = "/cars")
    public List<Car> getCars() {
        return getCarService().getCars();
    }

    @RequestMapping(path = "/search")
    public List<Car> getUserRequestedCar(@RequestParam("make") String make,
                                         @RequestParam("model") String model,
                                         @RequestParam("year") String year,
                                         @RequestParam(value = "radius", required = false) String radius,
                                         @RequestParam(value = "zipCode", required = false) String zipCode ) {
        if (radius == "" || zipCode == "") {
            return getCarService().getCarsBySearch(make, model, year);
        }
        return getCarService().getCarsBySearch(make, model, year, radius, zipCode);
    }
}
