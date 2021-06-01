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
		notification.setSeen(false);
		Notification savedNotification = notificationDao.save(notification);
		userDao.save(user);
		return savedNotification;
	}

	@Override
	public List<Notification> getAllNotificationsByUserId(long idUser) {
		// TODO Auto-generated method stub
		User user = userDao.findById(idUser).get();
		List<Notification> notification = user.getNotifications();
		notification.sort((o1, o2) -> o2.getCreatedAt().compareTo(o1.getCreatedAt()));
		return notification;
	}

	@Override
	public User updateUserNotification(long idUser, String token) {
		// TODO Auto-generated method stub
		User user = userDao.findById(idUser).get();
		user.setNotificationToken(token);
		userDao.save(user);
		return user;
	}

	@Override
	public void changeStatus(long idNotification) {
		// TODO Auto-generated method stub
		Notification notification = notificationDao.findById(idNotification).get();
		if (notification != null) {
			notification.setSeen(true);
			notificationDao.save(notification);
		}
	}

}
