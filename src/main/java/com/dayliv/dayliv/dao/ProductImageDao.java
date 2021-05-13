package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayliv.dayliv.model.ProductImage;

public interface ProductImageDao extends JpaRepository<ProductImage, Long> {

}
