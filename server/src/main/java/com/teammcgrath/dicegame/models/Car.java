package com.teammcgrath.dicegame.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

    @JsonProperty("vin") private String vin;
    @JsonProperty("price") private int price;
    @JsonProperty("miles") private int miles;
    @JsonProperty("exterior_color") private String exteriorColor;
    @JsonProperty("media") private Media media;
    @JsonProperty("build") private BuildDetails buildDetails;
    @JsonProperty("dealer") private Dealer dealer;

    @JsonCreator
    public Car(@JsonProperty("vin") String vin,
               @JsonProperty("price") int price,
               @JsonProperty("miles") int miles,
               @JsonProperty("exterior_color") String exteriorColor,
               @JsonProperty("media") Media media,
               @JsonProperty("build") BuildDetails buildDetails,
               @JsonProperty("dealer") Dealer dealer
               ) {
        this.vin = vin;
        this.price = price;
        this.miles = miles;
        this.exteriorColor = exteriorColor;
        this.media = media;
        this.buildDetails = buildDetails;
        this.dealer = dealer;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public BuildDetails getBuildDetails() {
        return buildDetails;
    }

    public void setBuildDetails(BuildDetails buildDetails) {
        this.buildDetails = buildDetails;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
