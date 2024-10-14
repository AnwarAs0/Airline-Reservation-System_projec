package com.project.Airline.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.project.Airline.models.Passenger;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private TemplateEngine templateEngine;

	public void sendBookingConfirmationEmail(String flightName, String origin, String destination, Date departureDate,
			Passenger passenger, String passengerEmail) throws MessagingException {
		
		// Create email context with variables
		Context context = new Context();
	    context.setVariable("passenger", passenger); // Set passenger in context
	    context.setVariable("flightName", flightName);
	    context.setVariable("origin", origin);
	    context.setVariable("destination", destination);
	    context.setVariable("departureDate", departureDate);
	    
	    String htmlContent = templateEngine.process("emailContent", context);
		
		// Sending Mail
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		helper.setText(htmlContent, true); // enabling HTML Format
		helper.setSubject("Booking Confirmation for " + flightName);
		helper.setTo(passengerEmail);
		
		mailSender.send(mimeMessage);
		
	}

    
}

