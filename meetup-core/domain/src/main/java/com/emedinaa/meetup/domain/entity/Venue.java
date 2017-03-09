package com.emedinaa.meetup.domain.entity;

import java.io.Serializable;

/**
 * Created by eduardomedina on 13/12/16.
 */
public class Venue implements Serializable {

    private String country;
    private String countryName;
    private String city;
    private String address;
    private String name;
    private String id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "country='" + country + '\'' +
                ", countryName='" + countryName + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
