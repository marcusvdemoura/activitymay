package com.marcusmoura.activitygn.services;

import com.marcusmoura.activitygn.entities.Metrics;
import com.marcusmoura.activitygn.repositories.MetricsRepository;
import com.marcusmoura.activitygn.services.exceptions.DataIntegrityException;
import com.marcusmoura.activitygn.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MetricsService {
    @Autowired
    private MetricsRepository repo;

    public Metrics find(Integer id){
        Optional<Metrics> metrics = repo.findById(id);
        return metrics.orElseThrow(()->new ObjectNotFoundException("Metrics not found"));
    }

    public List<Metrics> findAll(){
        return repo.findAll();
    }

    public Metrics insert(Metrics metrics){
        LocalDateTime ldt = LocalDateTime.now();
        metrics.setLocalDateTime(ldt);
        if(metrics.getHumidity() < 0 || metrics.getHumidity() > 100){
            throw new IllegalArgumentException("Humidity has to be between 0 and 100");
        }
        return repo.save(metrics);
    }

    public Metrics update(Metrics metrics){
        find(metrics.getId());
        return repo.save(metrics);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException(
                    "It's not possible to delete metrics with id " + id);
        }
    }

}
