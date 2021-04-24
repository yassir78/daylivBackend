package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.NotificationDao;
import com.dayliv.dayliv.dao.UserDao;
import com.dayliv.dayliv.model.Notification;
import com.dayliv.dayliv.model.User;
import com.dayliv.dayliv.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	private UserDao userDao;

	@Override
	public Notification save(long idUser, Notification notification) {
		// TODO Auto-generated method stub
		User user = userDao.findById(idUser).get();
		notification.setUser(user);
		Notification savedNotification = notificationDao.save(notification);
		userDao.save(user);
		return savedNotification;
	}

	@Override
	public List<Notification> getAllNotificationsByUserId(long idUser) {
		// TODO Auto-generated method stub
		User user = userDao.findById(idUser).get();
		return user.getNotifications();
	}

}
