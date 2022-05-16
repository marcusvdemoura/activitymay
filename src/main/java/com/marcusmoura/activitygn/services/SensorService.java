package com.marcusmoura.activitygn.services;

import com.marcusmoura.activitygn.entities.Sensor;
import com.marcusmoura.activitygn.repositories.SensorRepository;
import com.marcusmoura.activitygn.services.exceptions.DataIntegrityException;
import com.marcusmoura.activitygn.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    @Autowired
    private SensorRepository repo;

    public Sensor find(Integer id){
        Optional<Sensor> sensor = repo.findById(id);
        return sensor.orElseThrow(()-> new ObjectNotFoundException(
                "Sensor with id " + id + " not found!"));
    }

    public List<Sensor> findAll(){
        return repo.findAll();
    }

    public Sensor insert(Sensor s){
        return repo.save(s);
    }

    public Sensor update(Sensor s){
        find(s.getId());
        return repo.save(s);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException(
                    "It's not possible to delete sensor with id: " + id);
        }
    }
}
