package com.dayliv.dayliv.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.StoreDao;
import com.dayliv.dayliv.model.Product;
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

	@Override
	public Map<String, Object> getAllStores(String name, int page, int size) {
		 List<Store> stores = new ArrayList<Store>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Store> pagecats;
	      if (name == null)
	    	  pagecats = storeDao.findAll(paging);
	      else
	    	  pagecats = storeDao.findByNameContaining(name, paging);

	      stores = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("stores", stores);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;

	}
	
			public String findAddressByCode(String code) {
				// TODO Auto-generated method stub$
				Store store = storeDao.findByCode(code);
				if(store != null && !store.getAddress().equals("")) {
					return store.getAddress();
				}
				return "";
	}
}
