package com.dayliv.dayliv.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.CategoryPartenaire;
import com.dayliv.dayliv.model.CategoryProduct;
@Repository
@CrossOrigin
public interface CategoryPartenaireDao extends JpaRepository<CategoryPartenaire, Long>{
	public Page<CategoryPartenaire> findByNomContaining(String name, Pageable pageable);
}
