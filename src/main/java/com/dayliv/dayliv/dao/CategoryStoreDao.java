
package com.dayliv.dayliv.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.CategoryStore;
@Repository
@CrossOrigin
public interface CategoryStoreDao extends JpaRepository<CategoryStore, Long>{
	public CategoryStore findByLink(String link);
	public Page<CategoryStore> findByNomContaining(String name, Pageable pageable);
}
