package com.dayliv.dayliv.serviceIml;

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
		// TODO Auto-generated method stub
		return consumerDao.findAll();
	}

	@Override
	public Consumer save(Consumer consumer) {
		// TODO Auto-generated method stub
		return consumerDao.save(consumer);
	}

}
