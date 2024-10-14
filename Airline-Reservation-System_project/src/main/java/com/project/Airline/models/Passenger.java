package com.project.Airline.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String proof;
	private String gender;
	private int age;
	private String passengerType;
	
	//Constructor
	public Passenger() {}
	
	public Passenger(String name, String email, String proof, String gender, int age) {
		this.name = name;
		this.email = email;
		this.proof = proof;
		this.gender = gender;
		this.age = age;
		this.passengerType = classifyPassenger(age);
	}
	
	private String classifyPassenger(int age) {
		if(age <= 12) {
			return "Child";
		}else if(age >= 60) {
			return "Senior Citizen";
		}else {
			return "Adult";
		}
	}
	
	// Getter and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProof() {
		return proof;
	}

	public void setProof(String proof) {
		this.proof = proof;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		this.passengerType = classifyPassenger(age);
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

}
