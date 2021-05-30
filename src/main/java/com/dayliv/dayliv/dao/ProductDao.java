package com.dayliv.dayliv.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Product;

@Repository
@CrossOrigin
public interface ProductDao extends JpaRepository<Product, Long> {
	public List<Product> findBystoreCode(String storeCode);
	public Page<Product> findByLibelleContaining(String name, Pageable pageable);
	@Query("select product from Product product order by rand() ")
	public List<Product> findProductsRandomly();

}
