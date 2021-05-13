package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;

import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.model.Partenaire;

public interface DispatcherService {
	public List<Dispatcher> findAll();
	public Dispatcher save(Dispatcher dispatcher);

	public int delete(Long id);

	public Dispatcher update(Long id, Dispatcher dispatcher);

	public Dispatcher findByNom(String nom);

	public Dispatcher findById(Long id);

	public Dispatcher findByLogin(String login);
	public Map<String, Object> getAllDispatchers(String name, int page, int size);

}
