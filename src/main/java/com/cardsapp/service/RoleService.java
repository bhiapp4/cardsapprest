package com.cardsapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsapp.dao.RoleRepository;
import com.cardsapp.model.Role;


@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
			
	public Role save(Role role) throws Exception{
		if(role.getId() == null) {
			role.setCreatedDateTime(LocalDateTime.now());	
		}
		role.setUpdatedDateTime(LocalDateTime.now());
		
		return roleRepository.save(role);
	}
	
	public List<Role>getAll() throws Exception{
		List<Role>roles = roleRepository.findAll();
		return roles;
	}
	
	public Role getOne(long id) throws Exception{
		return roleRepository.findById(id).get();
	}
	
	public void delete(long id) throws Exception{
		roleRepository.deleteById(id);
	}

}
