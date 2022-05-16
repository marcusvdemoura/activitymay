package com.marcusmoura.activitygn.entities.dto;

import com.marcusmoura.activitygn.entities.Sensor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MetricsDTO {
    private Integer id;

    @NotNull
    private Double temperature;
    private Double windSpeed;
    private Double humidity;
    @NotNull
    private Sensor sensor;
    @NotNull
    private LocalDateTime dateTime;

    public MetricsDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
