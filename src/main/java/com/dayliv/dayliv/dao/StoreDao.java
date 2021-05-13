package com.dayliv.dayliv.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Store;

@Repository
@CrossOrigin
public interface StoreDao extends JpaRepository<Store, Long> {
	public Store findByCode(String code);
	public Page<Store> findByNameContaining(String name, Pageable pageable);

}
