package com.project.Airline.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Airline.models.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	
	List<Flight> findByOriginAndDestination(String origin, String destination);

}
