package com.cardsapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardsapp.model.User;
import com.cardsapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User create(@Valid @RequestBody User user) throws Exception {
		return userService.save(user);
	}

	@PutMapping
	public User update(@RequestBody User user) throws Exception {
		return userService.save(user);
	}
	
	@PatchMapping
	public User partialUpdate(@RequestBody User user) throws Exception {
		return userService.partialUpdate(user);
	}

	/*
	@PutMapping("/{userId}/{roleId}")
	public User updateUserWithRole(@PathVariable("userId") long userId, @PathVariable("roleId") long roleId) throws Exception {
		return userService.assignRoleToUser(userId, roleId);
	}
	*/
	
	@PutMapping("/{userId}")
	public HttpStatus updateUserToMultipleRoles(@PathVariable("userId") long userId, @RequestBody List<Long>roleIds) throws Exception {
		userService.assignMultipleRolesToUser(userId, roleIds);
		return HttpStatus.OK;
	}
	
	/*
	@PutMapping
	public User updateUserWithRoleWithRequestParams(@RequestParam("userId") long userId, @RequestParam("roleId") long roleId) throws Exception {
		return userService.assignRoleToUser(userId, roleId);
	}
	*/

	@DeleteMapping("/{id}")
	public HttpStatus delete(@PathVariable("id") long id) throws Exception{
		userService.delete(id);
		return HttpStatus.OK;
	}

	@GetMapping("/{id}")
	public User getUserById(long id) throws Exception {
		return userService.getOne(id);
	}

	@GetMapping
	public List<User> getAll() throws Exception {
		return userService.getAll();
	}

}
