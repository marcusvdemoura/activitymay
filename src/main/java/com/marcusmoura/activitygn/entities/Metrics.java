package com.marcusmoura.activitygn.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Metrics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Double temperature;
    private Double windSpeed;
    private Double humidity;
    @ManyToOne
    @JoinColumn(name = "sensor_id")
    @JsonIgnoreProperties(value = {"temperature", "windSpeed", "humidity"})
    private Sensor sensor;
    private LocalDateTime localDateTime;

    public Metrics() {
    }

    public Metrics(Integer id, Sensor sensor) {
        this.id = id;
        this.sensor = sensor;
        this.temperature = sensor.getTemperature();
        this.windSpeed = sensor.getWindSpeed();
        this.humidity = sensor.getHumidity();
        this.localDateTime = LocalDateTime.now();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Metrics{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", humidity=" + humidity +
                ", sensor=" + sensor +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
