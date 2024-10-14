package com.project.Airline.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;



@Entity
@Data
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String flightName;
	private String flightImage;
	private String origin;
	private String destination;
	
	@Temporal(TemporalType.DATE)
	private Date departureDate;
	private int availableSeats;
	private String price;
	
	
	public Flight() {}
	
	public Flight(String flightName,  String flightImage, String origin, String destination, Date departureDate, int availableSeats) {
		this.flightName = flightName;
		this.flightImage = flightImage;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.availableSeats = availableSeats;
	}
}
