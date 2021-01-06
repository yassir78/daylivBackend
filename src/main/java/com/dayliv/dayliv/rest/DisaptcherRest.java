package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.service.DispatcherService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/dispatcher")
public class DisaptcherRest {
	@Autowired
	private DispatcherService dispatcherService;

	@GetMapping("/")
	public List<Dispatcher> findAll() {
		return dispatcherService.findAll();
	}

}
