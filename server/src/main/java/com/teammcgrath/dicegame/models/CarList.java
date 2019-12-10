package com.teammcgrath.dicegame.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarList {

    @JsonProperty("listings") private List<Car> listings;

    public CarList(@JsonProperty("listings") List<Car> listings) {
        this.listings = listings;
    }

    public List<Car> getListings() {
        return listings;
    }

    public void setListings(List<Car> listings) {
        this.listings = listings;
    }
}
