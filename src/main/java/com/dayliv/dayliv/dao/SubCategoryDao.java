package com.dayliv.dayliv.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dayliv.dayliv.model.CategoryProduct;
import com.dayliv.dayliv.model.SubCategory;
@Repository
public interface SubCategoryDao extends JpaRepository<SubCategory, Long> {
	public List<SubCategory> findByStoreCode(String storeCode);

}
