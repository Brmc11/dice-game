package com.teammcgrath.dicegame.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dealer {
    @JsonProperty("name") private String name;
    @JsonProperty("street") private String street;
    @JsonProperty("city") private String city;
    @JsonProperty("state") private String state;

    @JsonCreator
    public Dealer(@JsonProperty("name") String name,
                  @JsonProperty("street") String street,
                  @JsonProperty("city") String city,
                  @JsonProperty("state") String state) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
