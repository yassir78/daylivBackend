package com.dayliv.dayliv.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Product;
import com.ibm.icu.math.BigDecimal;

@Repository
@CrossOrigin
public interface ProductDao extends JpaRepository<Product, Long> {
	public List<Product> findBystoreCode(String storeCode);

	@Query("select product from Product product order by rand() ")
	public List<Product> findProductsRandomly();

	@Query("SELECT p FROM Product p WHERE p.libelle like %?1% and p.storeCode = ?2")
	public Page<Product> findByLibelleAndStoreCodeContaining(String libelle, String storecode, Pageable pageable);

	public Page<Product> findByStoreCodeContaining(String storeCode, Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.subCategory.link like %?1% and p.storeCode = ?2")
	public Page<Product> findBySubCategorie(String link, String storeCode, Pageable pageable);

	@Query("SELECT p FROM Product p WHERE p.price between ?1 and ?2 and p.storeCode = ?3")
	public Page<Product> findByMaxAndMinPrice(Float minPrice, Float maxPrice, String storeCode,
			Pageable pageable);

}
