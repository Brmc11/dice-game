package com.teammcgrath.dicegame;

import com.teammcgrath.dicegame.models.Car;
import com.teammcgrath.dicegame.models.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class CarService {

    private RestTemplate restTemplate;

//    private String url = "https://marketcheck-prod.apigee.net/v1/search?api_key=";
    private static final String API_URL  = "https://marketcheck-prod.apigee.net/v1/search?api_key=";

    private String urlGetCars = "https://marketcheck-prod.apigee.net/v1/search?api_key=CvcyZGedAx4wVvY0KBZRbX3EcNweC4Ks&make=Honda&model=Accord&year=2000";

    private String urlGetCar = "https://marketcheck-prod.apigee.n,et/v1/listing/5TDYK3DC6ES502230-b3e95b45-72cf-45cb-8c04-47e532a37c9b?api_key=CvcyZGedAx4wVvY0KBZRbX3EcNweC4Ks";

    @Value("${marketcheck.api-key}")
    private String marketcheckApiKey;

    @Autowired
    public CarService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Car getCarById(String id) {
        return  restTemplate.getForObject(urlGetCar, Car.class);
    }

    public List<Car> getCars() {
        CarList response = restTemplate.getForObject(urlGetCars, CarList.class);
        return response.getListings();
    }


    public List<Car> getCarsBySearch(String make, String model, String year) {
        CarList response = restTemplate.getForObject(API_URL + marketcheckApiKey + "&make=" + make + "&model=" + model + "&year=" + year, CarList.class);
        return response.getListings();
    }
    public List<Car> getCarsBySearch(String make, String model, String year, String radius, String zipCode) {
        CarList response = restTemplate.getForObject(API_URL + marketcheckApiKey +
                                                    "&radius=" + radius +
                                                    "&zip=" + zipCode +
                                                    "&make=" + make +
                                                    "&model=" + model +
                                                    "&year=" + year,
                                                     CarList.class);
        return response.getListings();
    }

}
