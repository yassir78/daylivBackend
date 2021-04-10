package com.dayliv.dayliv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.CategoryProduct;

@Repository
@CrossOrigin
public interface CategoryProductDao extends JpaRepository<CategoryProduct, Long> {
	public List<CategoryProduct> findByStoreCode(String storeCode);
}
