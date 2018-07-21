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
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremented column
	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	
	@NotBlank(message="user name should be provided and it should be an email id")
	@Email(message="Email provided is invalid")
	private String userName;
	private String password;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Address address;
	
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST },
			targetEntity=Role.class)
		@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false) })
	private List<Role>roles;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	

}
