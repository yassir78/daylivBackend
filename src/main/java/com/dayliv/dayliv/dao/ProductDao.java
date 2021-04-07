package com.dayliv.dayliv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Product;

@Repository
@CrossOrigin
public interface ProductDao extends JpaRepository<Product, Long> {
	public List<Product> findBystoreCode(String storeCode);
}
