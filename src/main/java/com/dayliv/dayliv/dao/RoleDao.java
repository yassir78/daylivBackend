package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Role;

@Repository
@CrossOrigin
public interface RoleDao extends JpaRepository<Role,Long>{
	
	Role findByName(String name);
	}