package com.dayliv.dayliv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dayliv.dayliv.model.Notification;
import com.dayliv.dayliv.model.User;
import com.dayliv.dayliv.service.NotificationService;
import com.fasterxml.jackson.databind.node.TextNode;

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

	@PostMapping("/updateToken/{idUser}")
	public User updateUserTokenNotification(@PathVariable long idUser,@RequestHeader("token") String token) {
		System.out.println("////////////////////////////////////////////////////");
		System.out.println(token);
		return notificationService.updateUserNotification(idUser, token);
	}

}
