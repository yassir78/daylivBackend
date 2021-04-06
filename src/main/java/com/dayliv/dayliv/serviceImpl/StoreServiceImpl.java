package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.StoreDao;
import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.service.StoreService;
@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
   private StoreDao  storeDao;
	@Override
	public List<Store> findAll() {
		return storeDao.findAll();
	}

	@Override
	public Store createStore(Store store) {
		return storeDao.save(store);
	}

	@Override
	public Store updateStore(Store store) {
		return storeDao.save(store);
	}

	@Override
	public void deleteStore(Long id) {
	 storeDao.deleteById(id);
	}

	@Override
	public Store findById(Long id) {
		return storeDao.findById(id).get();
	}

	@Override
	public Store findByCode(String code) {
		return storeDao.findByCode(code);
	}

}
