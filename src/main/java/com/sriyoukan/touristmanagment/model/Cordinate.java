package com.sriyoukan.touristmanagment.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cordinate")
public class Cordinate {
    private float lat;
    private float lon;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
