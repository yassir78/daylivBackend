package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.service.CommandeService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/commandeItem")
public class CommandeItemRest {
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}

}
