package com.project.Airline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Airline.models.Flight;
import com.project.Airline.repositories.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> findAvailableFlight(String origin, String destination) {
		return flightRepository.findByOriginAndDestination(origin, destination);
	}

	public Flight findFlightById(Long flightId) {
		return flightRepository.findById(flightId).orElse(null);
	}

}
