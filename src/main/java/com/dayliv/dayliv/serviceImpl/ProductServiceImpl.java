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

import com.dayliv.dayliv.dao.PartenaireDao;
import com.dayliv.dayliv.dao.ProductDao;
import com.dayliv.dayliv.dao.ProductImageDao;
import com.dayliv.dayliv.dao.UserDao;
import com.dayliv.dayliv.model.CategoryPartenaire;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.model.ProductImage;
import com.dayliv.dayliv.model.User;
import com.dayliv.dayliv.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private PartenaireDao partenaireDao;
	@Autowired
	private ProductImageDao productImageDao;

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product createProduct(Product product, String idUser) {
		// TODO Auto-generated method stub
		Partenaire partenaire = partenaireDao.findById(Long.valueOf(idUser)).get();
		product.setPartenaire(partenaire);
		System.out.println("*********************************");
		Product savedProduct  = productDao.save(product);
		if (product.getProductImages() != null) {
			for (ProductImage image : product.getProductImages()) {
				System.out.println("*********************************");
				System.out.println(image.getPath());
				image.setProduct(savedProduct);
				productImageDao.save(image);
			}
		}
		return savedProduct;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public int deleteProduct(Long id) {
		// TODO Auto-generated method stub
		Product productToDelete = productDao.getOne(id);
		productDao.delete(productToDelete);
		return 1;
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productDao.getOne(id);
	}

	@Override
	public List<Product> getProductsByStore(String storeCode) {
		// TODO Auto-generated method stub
		return productDao.findBystoreCode(storeCode);
	}

	@Override
	public Map<String, Object> getAllProducts(String name, String storeCode, int page, int size) {
		System.out.println("****************************************");
		System.out.println(name);
		System.out.println(storeCode);
        List<String> params = new ArrayList<String>();
        params.add(name);
        params.add(storeCode);
		 List<Product> products = new ArrayList<Product>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Product> pagecats;
	      if (name == null)
	    	  //pagecats = productDao.findAll(paging);
	    	  pagecats = productDao.findByStoreCodeContaining(storeCode, paging);
	      else
	    	   
	    	  pagecats = productDao.findByLibelleAndStoreCodeContaining(name, storeCode, paging);

	      products = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("products", products);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
	}
}
