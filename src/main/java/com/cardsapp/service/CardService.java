package com.cardsapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cardsapp.dao.CardRepository;
import com.cardsapp.model.Card;

@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;
		
	public Card save(Card card) throws Exception{
		if(card.getId() == null) {
			card.setCreatedDateTime(LocalDateTime.now());	
		}
		card.setUpdatedDateTime(LocalDateTime.now());
		
		return cardRepository.save(card);
	}
	
	public List<Card>getAll() throws Exception{
		return cardRepository.findAll();
	}
	
	public Card getOne(long id) throws Exception{
		return cardRepository.findById(id).get();
	}
	
	public void delete(long id) throws Exception{
		cardRepository.deleteById(id);
	}

	public void updateVoteCount(long id, int upVoteCount) {
		Card card = cardRepository.findById(id).get();
		card.setUpVoteCount(upVoteCount);
		cardRepository.save(card);
	}

}
