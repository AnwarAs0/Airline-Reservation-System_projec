package com.project.Airline.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Airline.models.Passenger;
import com.project.Airline.repositories.PassengerRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public void addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

	public Passenger findPassenger(Long passengerId) {
		return passengerRepository.findById(passengerId).orElse(null);
	};
}
