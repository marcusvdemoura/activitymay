package com.marcusmoura.activitygn.repositories;

import com.marcusmoura.activitygn.entities.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricsRepository extends JpaRepository<Metrics, Integer> {
}
