package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Consumer;

public interface ConsumerService {
	public List<Consumer> findAll();

	public Consumer save(Consumer consumer);
}
