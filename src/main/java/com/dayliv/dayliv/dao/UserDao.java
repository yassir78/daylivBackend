package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.User;

@Repository
@CrossOrigin
public interface UserDao extends JpaRepository<User,Long>{
	User findByEmail(String email);

	boolean existsByEmail(String email);
}
