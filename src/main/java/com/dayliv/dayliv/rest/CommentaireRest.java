package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Commentaire;
import com.dayliv.dayliv.service.CommentaireService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/commentaire")
public class CommentaireRest {
	@Autowired
	private CommentaireService commentaireService;

	@GetMapping("/")
	public List<Commentaire> findAll() {
		return commentaireService.findAll();
	}
}
