package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Notification;
import com.dayliv.dayliv.model.User;

public interface NotificationService {
	public Notification save(long idUser, Notification notification);

	public List<Notification> getAllNotificationsByUserId(long idUser);
	
	public User updateUserNotification(long idUser,String token);
	
	public void changeStatus(long idNotification);
}
