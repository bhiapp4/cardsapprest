package com.cardsapp.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsapp.dao.RoleRepository;
import com.cardsapp.dao.UserRepository;
import com.cardsapp.exceptions.NotFoundException;
import com.cardsapp.model.Role;
import com.cardsapp.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public User save(User user) throws Exception{
		if (user.getId() == null) {
			user.setCreatedDateTime(LocalDateTime.now());
		}
		user.setUpdatedDateTime(LocalDateTime.now());
		if(user.getAddress() != null) {
			user.getAddress().setUser(user);
		}
		
		return userRepository.save(user);
	}
	
	public User partialUpdate(User user) throws Exception{
		Optional<User> dbUserOptional = userRepository.findById(user.getId());
		User dbUser = dbUserOptional.get();
		BeanUtils.copyProperties(user, dbUser,getNullPropertyNames(user));
		return userRepository.save(dbUser);
	}
	
	private static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
 
	    Set<String> emptyNames = new HashSet<>();
	    for(java.beans.PropertyDescriptor pd : pds) {
		//check if value of this property is null then add it to the collection
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}

	public List<User> getAll() throws Exception{
		return userRepository.findAll();
	}
	
	public User getOne(long id) throws Exception{
		return userRepository.findById(id).get();
	}

	public void delete(long id) throws Exception{
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent()) {
			userRepository.deleteById(id);	
		}
		else {
			throw new NotFoundException("user with id "+id+" is not found for deletion");
		}
		
	}

	public User assignRoleToUser(long userId, long roleId) throws Exception{
		User user = userRepository.findById(userId).get();
		Role role = roleRepository.findById(roleId).get();
		user.getRoles().add(role);
		user = userRepository.save(user);
		return user;
	}
	
	public User assignMultipleRolesToUser(long userId, List<Long> roleIds) throws Exception{
		final User user = userRepository.findById(userId).get();
		roleIds.stream().forEach((roleId) ->{
			user.getRoles().add(roleRepository.findById(roleId).get());
		});
		return userRepository.save(user);
	}
}
