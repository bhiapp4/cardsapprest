package com.cardsapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Role implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name is missing")
	private String name;
	
	//@CheckCase(value=CaseMode.UPPER, message="Description has to be in upper case")
	private String description;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	
	@ManyToMany(fetch = FetchType.EAGER, 
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST },
			targetEntity=User.class)
		@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "role_id", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false) })
	private List<User>users;

}
