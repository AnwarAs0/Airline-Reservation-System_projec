package com.project.Airline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Airline.models.Flight;
import com.project.Airline.models.Passenger;
import com.project.Airline.services.EmailSenderService;
import com.project.Airline.services.FlightService;
import com.project.Airline.services.PassengerService;

import jakarta.mail.MessagingException;

@Controller
public class HomeController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
    @GetMapping("/")
    public String index() {
        return "index"; 
    }
    @GetMapping("/login")
    public String login() {
        return "login"; 
    }
    
    @GetMapping("/domesticFlight")
    public String domesticFlightBooking() {
        return "domesticBooking"; 
    }
    
    @GetMapping("/internationalFlight")
    public String internationalFlightBooking() {
        return "internationalBooking"; 
    }
    @GetMapping("/passengerInformation")
    public String getpassengerInformation() {
        return "passengerInformation"; 
    }
    
    
    // Searching Flights here
    
    @PostMapping("/searchFlights")
    public String searchFlights(@RequestParam("origin") String origin, @RequestParam("destination") String destination, Model model ) {
    	
    	if (origin == null || destination == null) {
            return "redirect:/internationalFlight";  // Redirect back if any required fields are missing
        }
    	
    	List<Flight> availableFlights = flightService.findAvailableFlight(origin, destination);
    	model.addAttribute("flights", availableFlights);
    	
    	return "availableFlights";
    }
    
    // getting user info
    @PostMapping("/passengerInformation")
    public String savePassengerInfo(@RequestParam String name, @RequestParam String email, 
    		@RequestParam String proof, @RequestParam String gender, @RequestParam int age,
    		@RequestParam Long flightId ,Model model) throws MessagingException {
        
    	// creating and saving passenger
        Passenger passenger = new Passenger(name, email, proof, gender, age);
        passengerService.addPassenger(passenger);
        
       // Fetching flight details
        Flight flight = flightService.findFlightById(flightId);
        
        // preparing data for the mail
        model.addAttribute("passenger", passenger);
        model.addAttribute("flight", flight);

        
        // sending Booking confirmation to mail
        emailSenderService.sendBookingConfirmationEmail(flight.getFlightName(), flight.getOrigin(), flight.getDestination(),
        		flight.getDepartureDate(), passenger, email);

    	
        model.addAttribute("successMessage", "Successfully Booked! Confirmation mail sent to " + email);

        return "passengerInformation";
    }

    
}