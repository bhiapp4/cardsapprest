package com.cardsapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardsapp.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
