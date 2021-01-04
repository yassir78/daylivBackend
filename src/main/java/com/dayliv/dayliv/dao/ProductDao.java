package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayliv.dayliv.model.Product;

public interface ProductDao extends JpaRepository<Product,Long> {

}
