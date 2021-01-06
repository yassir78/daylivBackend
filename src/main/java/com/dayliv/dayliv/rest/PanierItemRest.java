package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.PanierItem;
import com.dayliv.dayliv.service.PanierItemService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/panierItem")
public class PanierItemRest {
	@Autowired
	private PanierItemService panierItemService;

	@GetMapping("/")
	public List<PanierItem> findAll() {
		return panierItemService.findAll();
	}

}
