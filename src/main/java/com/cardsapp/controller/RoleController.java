package com.cardsapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cardsapp.model.Role;
import com.cardsapp.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@PostMapping
	@ResponseStatus(value=HttpStatus.CREATED)
	public Role create(@Valid @RequestBody Role role) throws Exception{
		return roleService.save(role);
	}
	
	@GetMapping
	public List<Role>getAll() throws Exception{
		return roleService.getAll();
	}
	
}
