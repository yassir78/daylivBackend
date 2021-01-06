package com.dayliv.dayliv.serviceIml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.IngredientDao;
import com.dayliv.dayliv.model.Ingredient;
import com.dayliv.dayliv.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {
	@Autowired
	private IngredientDao ingredientDao;

	@Override
	public List<Ingredient> findAll() {
		// TODO Auto-generated method stub
		return ingredientDao.findAll();
	}

}
