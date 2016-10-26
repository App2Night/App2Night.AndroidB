package com.julianriegraf.app2night.Models;

/**
 * Created by Julian Riegraf on 25.10.2016.
 */

public class PartyLocation {

    private String countryName;
    private String cityName;
    private String streetName;
    private int houseNumber;
    private String houseNumberAdditional;
    private int zipcode;
    private int latitude;
    private int longitude;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberAdditional() {
        return houseNumberAdditional;
    }

    public void setHouseNumberAdditional(String houseNumberAdditional) {
        this.houseNumberAdditional = houseNumberAdditional;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }




}
