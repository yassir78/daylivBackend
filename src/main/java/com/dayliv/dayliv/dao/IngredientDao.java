package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayliv.dayliv.model.Ingredient;

public interface IngredientDao  extends JpaRepository<Ingredient,Long>{

}
