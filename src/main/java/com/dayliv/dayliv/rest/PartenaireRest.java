package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Panier;
import com.dayliv.dayliv.service.PanierService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/partenaire")
public class PartenaireRest {
	@Autowired
	private PanierService panierService;

	@GetMapping("/")
	public List<Panier> findAll() {
		return panierService.findAll();
	}

}
