package com.emedinaa.meetup.data.entity;


/**
 * Created by eduardomedina on 13/12/16.
 */
public class VenueEntity  {

    private String country;
    private String localized_country_name;
    private String address_1;
    private String name;
    private String city;
    private String id;
    private String lon;
    private String lat;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocalized_country_name() {
        return localized_country_name;
    }

    public void setLocalized_country_name(String localized_country_name) {
        this.localized_country_name = localized_country_name;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
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

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
