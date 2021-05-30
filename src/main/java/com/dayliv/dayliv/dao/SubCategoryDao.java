package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dayliv.dayliv.model.SubCategory;
@Repository
public interface SubCategoryDao extends JpaRepository<SubCategory, Long> {

}
