package com.dayliv.dayliv.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//		emailService.sendMail(commande.getLivraisonInfos().getEmail(), "Dayliv Marketplace", "Votre commande a été bien reçu !");
//
//		emailService.sendMail(commande.getLivreur().getEmail(), "Dayliv Marketplace", "Bonjour vous avez reçu une nouvelle commande !");
		return commandeService.save(commande);
	}

	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeService.findAll();
	}

	

	@GetMapping("/store/{storeCode}")
	public List<Commande> findAllByStoreCode(@PathVariable String storeCode) {
		return commandeService.findAll();
	}

	@PostMapping("/changeStatus/{id}")
	public Commande changeStatus(@PathVariable Long id,@RequestHeader("status") String status) {
		System.out.println("//////////////////////////////");
		System.out.println(status);
		return commandeService.changeStatus(status, id);
		
	}
	

	@GetMapping("/commandes")
	  public ResponseEntity<Map<String, Object>> getAllCategories(
	        @RequestParam(required = false) String name,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "3") int size
	      ) {
       try {
	    
	      return new ResponseEntity<>(commandeService.getAllCommandes(name, page, size), HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
