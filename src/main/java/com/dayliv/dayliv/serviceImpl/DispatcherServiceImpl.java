package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.DispatcherDao;
import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.service.DispatcherService;

@Service
public class DispatcherServiceImpl implements DispatcherService {
	@Autowired
	private DispatcherDao DispatcherDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public List<Dispatcher> findAll() {
		// TODO Auto-generated method stub
		return DispatcherDao.findAll();
	}

	@Override
	public Dispatcher save(Dispatcher dispatcher) {
		// TODO Auto-generated method stub
		String password =passwordEncoder.encode(dispatcher.getPassword());
		dispatcher.setPassword(password);
		return DispatcherDao.save(dispatcher);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
				DispatcherDao.deleteById(id);
				return 1;
	}

	@Override
	public Dispatcher update(Long id, Dispatcher dispatcher) {
		// TODO Auto-generated method stub
		return DispatcherDao.save(dispatcher);
	}

	@Override
	public Dispatcher findByNom(String nom) {
		// TODO Auto-generated method stub
		return DispatcherDao.findByNom(nom);
	}

	@Override
	public Dispatcher findById(Long id) {
		// TODO Auto-generated method stub
		return DispatcherDao.getOne(id);
	}

	@Override
	public Dispatcher findByLogin(String login) {
		// TODO Auto-generated method stub
		return DispatcherDao.findByLogin(login);
	}

}
