package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dayliv.dayliv.model.SuperAdmin;
@Repository
@CrossOrigin
public interface SuperAdminDao extends JpaRepository<SuperAdmin,Long> {

}
