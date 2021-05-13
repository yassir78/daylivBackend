package com.dayliv.dayliv.service;

import java.util.List;
import java.util.Map;

import com.dayliv.dayliv.model.Store;

public interface StoreService {
	public List<Store> findAll();

	public Store createStore(Store store);

	public Store updateStore(Store store);

	public void deleteStore(Long id);

	public Store findById(Long id);
	
	public Store findByCode(String code);
	public Map<String, Object> getAllStores(String name, int page, int size);

}
