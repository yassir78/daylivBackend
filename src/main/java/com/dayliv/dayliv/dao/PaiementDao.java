package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayliv.dayliv.model.Paiement;

public interface PaiementDao extends JpaRepository<Paiement, Long> {

}
