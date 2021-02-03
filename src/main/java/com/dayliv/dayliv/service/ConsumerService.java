package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Consumer;

public interface ConsumerService {
	public List<Consumer> findAll();

	public Consumer save(Consumer consumer);
	
	  public Consumer  findByLogin(String login);

	public void delete(Long id);

	public Consumer update(Long id, Consumer consumer);

	public Consumer findByNom(String nom);

	public Consumer findById(Long id);
}
