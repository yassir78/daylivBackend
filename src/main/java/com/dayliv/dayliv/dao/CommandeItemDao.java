package com.dayliv.dayliv.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dayliv.dayliv.model.CommandeItem;

public interface CommandeItemDao extends JpaRepository<CommandeItem, Long> {

}
