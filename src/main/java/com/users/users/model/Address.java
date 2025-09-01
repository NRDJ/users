package com.users.users.model;

public class Address {
    private String street;
    private String city;
    private String commune;
    private String region;
    private String zip;

    public Address() {}

    public Address(String street, String city, String commune, String region, String zip) {
        this.street = street;
        this.city = city;
        this.commune = commune;
        this.region = region;
        this.zip = zip;
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

    public String getCommune() { 
        return commune; 
    }
    
    public void setCommune(String commune) { 
        this.commune = commune; 
    }

    public String getRegion() { 
        return region; 
    }

    public void setRegion(String region) { 
        this.region = region; 
    }

    public String getZip() { 
        return zip; 
    }

    public void setZip(String zip) { 
        this.zip = zip; 
    }
}