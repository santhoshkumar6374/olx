package com.bustrack.bustrack.repository;

import com.bustrack.bustrack.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    Optional<Bus> findByBusNumber(String busNumber);

}
