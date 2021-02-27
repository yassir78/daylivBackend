package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.service.CommandeService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/commande")
public class CommandeRest {
	@Autowired
	private CommandeService commandeService;
    @PostMapping("/save")
	public Commande save(@RequestBody Commande commande) {
		return commandeService.save(commande);
	}

	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}

}
