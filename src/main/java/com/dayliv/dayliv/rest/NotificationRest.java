package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Notification;
import com.dayliv.dayliv.service.NotificationService;

@RestController
@CrossOrigin
@RequestMapping("/dayliv-api/notification")
public class NotificationRest {

	@Autowired
	private NotificationService notificationService;
    @GetMapping("/{idUser}")
	public List<Notification> getAllNotificationsByUserId(@PathVariable long idUser) {
		return notificationService.getAllNotificationsByUserId(idUser);
	}

	@PostMapping("/{idUser}")
	public Notification save(@PathVariable long idUser, @RequestBody Notification notification) {
		return notificationService.save(idUser, notification);
	}

}
