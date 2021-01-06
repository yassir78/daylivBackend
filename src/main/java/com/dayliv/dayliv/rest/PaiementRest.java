package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Paiement;
import com.dayliv.dayliv.service.PaiementService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/paiement")
public class PaiementRest {
	@Autowired
	private PaiementService paiementService;

	@GetMapping("/")
	public List<Paiement> findAll() {
		return paiementService.findAll();
	}

}
