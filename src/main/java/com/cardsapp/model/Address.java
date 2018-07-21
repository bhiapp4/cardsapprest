package com.cardsapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "user")
public class Address implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private String city;
	private String state;
	private String country;
	private String zip;
	
	@OneToOne
	@Id
	@JoinColumn(name="userId")
	private User user;
}
