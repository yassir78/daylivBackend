
package com.dayliv.dayliv.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CategoryStoreDao;
import com.dayliv.dayliv.model.CategoryStore;
import com.dayliv.dayliv.service.CategoryStoreService;

@Service
public class CategoryStoreServiceImpl implements CategoryStoreService {
	@Autowired
	private CategoryStoreDao categoryStoreDao;

	@Override
	public List<CategoryStore> findAll() {
		return categoryStoreDao.findAll();
	}
	
	
	public Map<String, Object> getAllCategories(String name, int page, int size){
		  List<CategoryStore> categories = new ArrayList<CategoryStore>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<CategoryStore> pagecats;
	      if (name == null)
	    	  pagecats = categoryStoreDao.findAll(paging);
	      else
	    	  pagecats = categoryStoreDao.findByNomContaining(name, paging);

	      categories = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("categories", categories);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
		
	}

}

