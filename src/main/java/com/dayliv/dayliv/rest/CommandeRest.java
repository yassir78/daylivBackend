package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.CommandeService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/commande")
public class CommandeRest {
	@Autowired
	private CommandeService commandeService;

	@GetMapping("/liv/{id}")
	public List<Commande> getCommandeByLivreur(@PathVariable Long id) {
		return commandeService.getCommandeByLivreur(id);
	}

	@PostMapping("/setLivreur/{id}")
	public Commande affecterCommandeLivreur(@RequestBody Livreur livreur, @PathVariable Long id) {
		return commandeService.affecterCommandeLivreur(livreur, id);
	}

	@PostMapping("/save")
	public Commande save(@RequestBody Commande commande) {
		System.out.println("Commande..............");
		System.out.println(commande);
		return commandeService.save(commande);
	}

	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}

}
