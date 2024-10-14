package com.project.Airline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Airline.models.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
