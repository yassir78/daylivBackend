package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.service.ConsumerService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/consumer")
public class ConsumerRest {
	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/")
	public List<Consumer> findAll() {
		return consumerService.findAll();
	}

}
