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

import com.dayliv.dayliv.dao.CategoryProductDao;
import com.dayliv.dayliv.dao.StoreDao;
import com.dayliv.dayliv.dao.SubCategoryDao;
import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.model.Store;
import com.dayliv.dayliv.model.SubCategory;
import com.dayliv.dayliv.service.CategoryProductService;

@Service
public class CategoryProductServiceImpl implements CategoryProductService {
	@Autowired
	private CategoryProductDao categoryProductDao;
	@Autowired
	private StoreDao storeDao;
@Autowired
private SubCategoryDao subCategoryDao;
	@Override
	public List<CategoryProduct> findAll() {
		// TODO Auto-generated method stub
		return categoryProductDao.findAll();
	}

	@Override
	public List<CategoryProduct> getCategoriesByStoreCode(String code) {
		// TODO Auto-generated method stub
		System.out.println("this is sparta");
		Store store = storeDao.findByCode(code);
		if (store != null) {
			System.out.println("this is Ch3kouka");
			return categoryProductDao.findByStoreCode(code);
		}
		return null;
	}

	@Override
	public CategoryProduct save(CategoryProduct categoryProduct) {
		// TODO Auto-generated method stub
		System.out.println("******categoryProduct***");
		System.out.println(categoryProduct);
		CategoryProduct cat = categoryProductDao.save(categoryProduct);
		if(categoryProduct.getSousCategories()!=null) {
			for(SubCategory subCat:categoryProduct.getSousCategories()) {
				subCat.setCategoryProduct(cat);
				subCategoryDao.save(subCat);
			}
		}
		return cat;
	}

	@Override
	public Map<String, Object> getAllCategories(String name, int page, int size) {
		 List<CategoryProduct> categoryProducts = new ArrayList<CategoryProduct>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<CategoryProduct> pagecats;
	      if (name == null)
	    	  pagecats = categoryProductDao.findAll(paging);
	      else
	    	  pagecats = categoryProductDao.findByCategorieContaining(name, paging);

	      categoryProducts = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("categoryProducts", categoryProducts);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
	}

}
