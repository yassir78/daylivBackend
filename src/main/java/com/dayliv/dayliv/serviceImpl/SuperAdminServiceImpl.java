package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.SuperAdminDao;
import com.dayliv.dayliv.model.SuperAdmin;
import com.dayliv.dayliv.service.SuperAdminService;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
	@Autowired
	private SuperAdminDao superAdminDao;

	@Override
	public List<SuperAdmin> findAll() {
		// TODO Auto-generated method stub
		return superAdminDao.findAll();
	}

}
