package com.teammcgrath.dicegame.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildDetails {
    @JsonProperty("year") private int year;
    @JsonProperty("make") private String make;
    @JsonProperty("model") private String model;
    @JsonProperty("trim") private String trim;
    @JsonProperty("transmission") private String transmission;
    @JsonProperty("engine") private String engine;
    @JsonProperty("cylinders") int cylinders;

    @JsonCreator
    public BuildDetails(@JsonProperty("year") int year,
                        @JsonProperty("make") String make,
                        @JsonProperty("model") String model,
                        @JsonProperty("trim") String trim,
                        @JsonProperty("transmission") String transmission,
                        @JsonProperty("engine") String engine,
                        @JsonProperty("cylinders")int cylinders) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.transmission = transmission;
        this.engine = engine;
        this.cylinders = cylinders;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }
}
