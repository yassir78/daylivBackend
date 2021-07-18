package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dayliv.dayliv.model.ProductImage;
@Repository
public interface ProductImageDao extends JpaRepository<ProductImage, Long> {

}
