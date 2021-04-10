package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.CommandeStatusDao;
import com.dayliv.dayliv.model.CommandeStatus;
import com.dayliv.dayliv.service.CommandeStatusService;

@Service
public class CommandeStatusServiceImpl implements CommandeStatusService {
	@Autowired
	private CommandeStatusDao commandeStatusDao;

	@Override
	public List<CommandeStatus> findAll() {
		// TODO Auto-generated method stub
		return commandeStatusDao.findAll();
	}

	@Override
	public void save(CommandeStatus commandeStatus) {
		commandeStatusDao.save(commandeStatus);
		
	}

}
