package com.dayliv.dayliv.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.CategoryProduct;

@Repository
@CrossOrigin
public interface CategoryProductDao extends JpaRepository<CategoryProduct, Long> {
	public List<CategoryProduct> findByStoreCode(String storeCode);
	public Page<CategoryProduct> findByCategorieContaining(String name, Pageable pageable);
	public CategoryProduct findByCategorie(String categorie);

}
