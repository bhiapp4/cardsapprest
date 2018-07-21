package com.cardsapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cardsapp.model.Card;
import com.cardsapp.service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {

	@Autowired
	private CardService cardService;

	@PostMapping
	public Card create(@Valid @RequestBody Card card) throws Exception {
		return cardService.save(card);
	}

	@PutMapping
	public Card update(@RequestBody Card card) throws Exception {
		return cardService.save(card);
	}

	@PutMapping("/{id}/{voteCount}")
	public HttpStatus updateVoteCount(@PathVariable("id") long id, @PathVariable("voteCount") int voteCount) throws Exception {
		cardService.updateVoteCount(id, voteCount);
		return HttpStatus.OK;
	}

	@DeleteMapping("/{id}")
	public HttpStatus delete(@PathVariable("id") long id) throws Exception {
		cardService.delete(id);
		return HttpStatus.OK;
	}

	@GetMapping("/{id}")
	public Card getCardById(@PathVariable("id") long id) throws Exception {
		return cardService.getOne(id);
	}

	@GetMapping
	public List<Card> getAll() throws Exception {
		return cardService.getAll();
	}

}
