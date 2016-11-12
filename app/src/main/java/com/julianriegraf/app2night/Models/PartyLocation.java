package com.julianriegraf.app2night.Models;

/**
 * Created by Julian Riegraf on 25.10.2016.
 */

public class PartyLocation {

    private String CountyName;
    private String CityName;
    private String StreetName;
    private int HouseNumber;
    private String HouseNumberAdditional;
    private int Zipcode;
    private double Latitude;
    private double Longitude;

    public String getCountyName() {
        return CountyName;
    }

    public void setCountyName(String countyName) {
        this.CountyName = countyName;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        this.CityName = cityName;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        this.StreetName = streetName;
    }

    public int getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.HouseNumber = houseNumber;
    }

    public String getHouseNumberAdditional() {
        return HouseNumberAdditional;
    }

    public void setHouseNumberAdditional(String houseNumberAdditional) {
        this.HouseNumberAdditional = houseNumberAdditional;
    }

    public int getZipcode() {
        return Zipcode;
    }

    public void setZipcode(int zipcode) {
        this.Zipcode = zipcode;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(int latitude) {
        this.Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(int longitude) {
        this.Longitude = longitude;
    }




}
