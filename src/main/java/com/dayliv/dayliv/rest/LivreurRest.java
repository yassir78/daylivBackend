package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.LivreurService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/livreur")
public class LivreurRest {
	@Autowired
	private LivreurService livreurService;

	@GetMapping("/")
	public List<Livreur> findAll() {
		return livreurService.findAll();
	}

}
