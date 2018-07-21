package com.cardsapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Card implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="First name is required")
	private String firstName;
	@NotBlank(message="Last name is required")
	private String lastName;
	private String middleName;
	
	@NotBlank(message="Email is required")
	@Email(message="Email should be in correct format")
	private String email;
	
	private String fax;
	
	@NotBlank(message="cell number is required")
	private String cell;
	
	@NotBlank(message="work number is required")
	private String work;
	
	private int upVoteCount;
	
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	
	private String createdBy;
	private String updatedBy;
	
}
