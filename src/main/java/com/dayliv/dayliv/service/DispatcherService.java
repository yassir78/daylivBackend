package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Dispatcher;

public interface DispatcherService {
	public List<Dispatcher> findAll();

	public Dispatcher save(Dispatcher dispatcher);

}
