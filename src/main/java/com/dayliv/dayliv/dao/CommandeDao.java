package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayliv.dayliv.model.Commande;

public interface CommandeDao extends JpaRepository<Commande, Long> {

}
