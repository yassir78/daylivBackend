package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Notification;

public interface NotificationService {
	public Notification save(long idUser, Notification notification);

	public List<Notification> getAllNotificationsByUserId(long idUser);
}
