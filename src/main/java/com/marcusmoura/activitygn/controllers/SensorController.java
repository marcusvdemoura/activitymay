package com.marcusmoura.activitygn.controllers;

import com.marcusmoura.activitygn.entities.Metrics;
import com.marcusmoura.activitygn.entities.Sensor;
import com.marcusmoura.activitygn.entities.dto.SensorDTO;
import com.marcusmoura.activitygn.services.MetricsService;
import com.marcusmoura.activitygn.services.SensorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "sensor")
public class SensorController {

    @Autowired
    private SensorService service;
    @Autowired
    private MetricsService metricsService;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Sensor> find(@PathVariable Integer id){
        Sensor sensor = service.find(id);
        return ResponseEntity.ok().body(sensor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Sensor>> findAll() {
        List<Sensor> sensors = service.findAll();
        return ResponseEntity.ok().body(sensors);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody SensorDTO sensorDTO) {

        Sensor sensor = service.insert(new ModelMapper().map(sensorDTO, Sensor.class));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(sensor.getId()).toUri();

        return ResponseEntity.created(uri).build();


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody SensorDTO sensorDTO, @PathVariable Integer id) {

        Sensor sensor = service.update(new ModelMapper().map(sensorDTO, Sensor.class));
        metricsService.insert(new Metrics(
                null,
                sensor
        ));

        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Sensor> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
