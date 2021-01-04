package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayliv.dayliv.model.CommandeStatus;

public interface CommandeStatusDao extends JpaRepository<CommandeStatus, Long> {

}
