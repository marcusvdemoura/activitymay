package com.marcusmoura.activitygn.controllers;

import com.marcusmoura.activitygn.entities.Metrics;
import com.marcusmoura.activitygn.entities.dto.MetricsDTO;
import com.marcusmoura.activitygn.services.MetricsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "metrics")
public class MetricsController {

    @Autowired
    private MetricsService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Metrics> find(@PathVariable Integer id) {
        Metrics metrics = service.find(id);
        return ResponseEntity.ok().body(metrics);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Metrics>> findAll() {
        List<Metrics> metricsList = service.findAll();
        return ResponseEntity.ok().body(metricsList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody MetricsDTO metricsDTO) {

        Metrics metrics = service.insert(new ModelMapper().map(metricsDTO, Metrics.class));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(metrics.getId()).toUri();

        return ResponseEntity.created(uri).build();


    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody MetricsDTO metricsDTO, @PathVariable Integer id) {

        Metrics metrics = service.update(new ModelMapper().map(metricsDTO, Metrics.class));

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Metrics> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
