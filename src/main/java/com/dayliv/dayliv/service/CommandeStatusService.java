package com.dayliv.dayliv.service;

import java.util.List;

import com.dayliv.dayliv.model.CommandeStatus;

public interface CommandeStatusService {
	public List<CommandeStatus> findAll();

	public void save(CommandeStatus commandeStatus);
}
