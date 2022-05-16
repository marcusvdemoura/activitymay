package com.marcusmoura.activitygn.entities.dto;


import javax.validation.constraints.NotEmpty;

public class SensorDTO {

    private Integer id;
    @NotEmpty(message ="Mandatory to fill in")
    private String Country;
    @NotEmpty(message ="Mandatory to fill in")
    private String city;
    @NotEmpty(message ="Mandatory to fill in")
    private String url;
    private Double temperature;
    private Double windSpeed;
    private Double humidity;

    public SensorDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
