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

import com.dayliv.dayliv.dao.CategoryPartenaireDao;
import com.dayliv.dayliv.model.CategoryPartenaire;
import com.dayliv.dayliv.service.CategoryPartenaireService;

@Service
public class CategoryPartenaireServiceImpl implements CategoryPartenaireService {
	@Autowired
	private CategoryPartenaireDao categoryPartenaireDao;

	@Override
	public List<CategoryPartenaire> findAll() {
		return categoryPartenaireDao.findAll();
	}
	
	
	public Map<String, Object> getAllCategories(String name, int page, int size){
		  List<CategoryPartenaire> categories = new ArrayList<CategoryPartenaire>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<CategoryPartenaire> pagecats;
	      if (name == null)
	    	  pagecats = categoryPartenaireDao.findAll(paging);
	      else
	    	  pagecats = categoryPartenaireDao.findByNomContaining(name, paging);

	      categories = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("categories", categories);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
		
	}

}
