package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.CommandeService;
import com.dayliv.dayliv.service.EmailService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/commande")
public class CommandeRest {
	@Autowired
	private CommandeService commandeService;
	@Autowired
    private EmailService emailService; 
	@GetMapping("/liv/{id}")
	public List<Commande> getCommandeByLivreur(@PathVariable Long id) {
		return commandeService.getCommandeByLivreur(id);
	}

	@PostMapping("/setLivreur/{id}")
	public Commande affecterCommandeLivreur(@RequestBody Livreur livreur, @PathVariable Long id) {
		emailService.sendMail(livreur.getEmail(), "Dayliv Marketplace", "Bonjour vous avez reçu une nouvelle commande !");
		return commandeService.affecterCommandeLivreur(livreur, id);
	}

	@PostMapping("/save")
	public Commande save(@RequestBody Commande commande) {
		System.out.println("Commande..............");
		System.out.println(commande);
		emailService.sendMail(commande.getLivreur().getEmail(), "Dayliv Marketplace", "Bonjour vous avez reçu une nouvelle commande !");
		return commandeService.save(commande);
	}

	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}
	@PostMapping("/changeStatus/{id}")
	public Commande changeStatus(@RequestHeader("status") String status,@PathVariable Long id) {
		return commandeService.changeStatus(status, id);
		
	}
	

}
