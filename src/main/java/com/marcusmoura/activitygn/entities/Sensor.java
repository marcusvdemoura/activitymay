package com.marcusmoura.activitygn.entities;

import javax.persistence.*;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String country;
    private String url;
    private String city;
    private Double temperature;
    private Double windSpeed;
    private Double humidity;




    public Sensor() {
    }


    public Sensor(Integer id, String country, String city, String url, Double temperature, Double windSpeed, Double humidity) {
        this.id = id;
        this.country = country;
        this.url = url;
        this.city = city;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.humidity = humidity;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", url='" + url + '\'' +
                ", city='" + city + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", humidity=" + humidity +
                '}';
    }
}

