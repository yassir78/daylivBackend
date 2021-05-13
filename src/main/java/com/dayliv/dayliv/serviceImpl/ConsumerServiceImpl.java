package com.dayliv.dayliv.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.ConsumerDao;
import com.dayliv.dayliv.model.Consumer;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.service.ConsumerService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	@Autowired
	private ConsumerDao consumerDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public List<Consumer> findAll() {
		return consumerDao.findAll();
	}

	@Override
	public Consumer save(Consumer consumer) {
		consumer.setPassword(passwordEncoder.encode(consumer.getPassword()));
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

	@Override
	public Map<String, Object> getAllConsumers(String name, int page, int size) {
		 List<Consumer> consumers = new ArrayList<Consumer>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Consumer> pagecats;
	      if (name == null)
	    	  pagecats = consumerDao.findAll(paging);
	      else
	    	  pagecats = consumerDao.findByNomContaining(name, paging);

	      consumers = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("consumers", consumers);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
	}

}
