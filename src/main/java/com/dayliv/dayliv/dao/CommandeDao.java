package com.dayliv.dayliv.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.Livreur;

@Repository
@CrossOrigin
public interface CommandeDao extends JpaRepository<Commande, Long> {
	@Query("SELECT c FROM Commande c WHERE c.livreur = ?1")
	public List<Commande> findByLivreur(Livreur livreur);
	List<Commande> findAllByStoreCode(String storeCode);
	public Page<Commande> findByReferenceContaining(String name, Pageable pageable);

}
