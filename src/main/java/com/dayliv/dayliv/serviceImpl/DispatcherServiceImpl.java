package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.DispatcherDao;
import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.service.DispatcherService;

@Service
public class DispatcherServiceImpl implements DispatcherService {
	@Autowired
	private DispatcherDao DispatcherDao;

	@Override
	public List<Dispatcher> findAll() {
		// TODO Auto-generated method stub
		return DispatcherDao.findAll();
	}

	@Override
	public Dispatcher save(Dispatcher dispatcher) {
		// TODO Auto-generated method stub
		return DispatcherDao.save(dispatcher);
	}

}
