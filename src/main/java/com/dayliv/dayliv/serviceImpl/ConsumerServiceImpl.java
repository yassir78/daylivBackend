package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.ConsumerDao;
import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	@Autowired
	private ConsumerDao consumerDao;

	@Override
	public List<Consumer> findAll() {
		return consumerDao.findAll();
	}

	@Override
	public Consumer save(Consumer consumer) {
		return consumerDao.save(consumer);
	}
	

	@Override
	public Consumer findByLogin(final String login) {
		return consumerDao.findByLogin(login).orElse(null);
	}

	@Override
	public void delete(Long id) {
		consumerDao.deleteById(id);		
	}

	@Override
	public Consumer update(Long id, Consumer consumer) {
		return consumerDao.save(consumer);
	}

	@Override
	public Consumer findByNom(String nom) {
		return consumerDao.findByNom(nom);
	}

	@Override
	public Consumer findById(Long id) {
		return consumerDao.getOne(id);
	}

}
