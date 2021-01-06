package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.service.CommandeStatusService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/commandeStatus")
public class CommandeStatusRest {
	@Autowired
	private CommandeStatusService commandeStatusService;

	@GetMapping("/")
	public List<CommandeStatus> findAll() {
		return commandeStatusService.findAll();
	}

}
