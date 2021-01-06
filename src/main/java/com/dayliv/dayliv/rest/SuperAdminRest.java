package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.SuperAdmin;
import com.dayliv.dayliv.service.SuperAdminService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/superAdmin")
public class SuperAdminRest {
	@Autowired
	private SuperAdminService superAdminService;

	@GetMapping("/")
	public List<SuperAdmin> findAll() {
		return superAdminService.findAll();
	}

}
