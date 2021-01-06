package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.Livreur;


public interface LivreurService {
   public List<Livreur> findAll();
   public Livreur save(Livreur livreur);
}
