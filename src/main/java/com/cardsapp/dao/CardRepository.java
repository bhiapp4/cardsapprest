package com.cardsapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cardsapp.model.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

}
