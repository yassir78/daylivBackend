package com.dayliv.dayliv.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Consumer;

@Repository
@CrossOrigin
public interface ConsumerDao extends JpaRepository<Consumer, Long> {
	public Optional<Consumer> findByLogin(String nom);

	public Consumer findByNom(String nom);

}
