package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.LivreurDao;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.service.LivreurService;

@Service
public class LivreurServiceImpl implements LivreurService {
	@Autowired
	private LivreurDao livreurDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public List<Livreur> findAll() {
		return livreurDao.findAll();
	}

	@Override
	public Livreur save(Livreur livreur) {
		livreur.setPassword(passwordEncoder.encode(livreur.getPassword()));
		return livreurDao.save(livreur);
	}

	@Override
	public void delete(Long id) {
		livreurDao.deleteById(id);
	}

	@Override
	public Livreur update(Long id, Livreur livreur) {
		return livreurDao.save(livreur);
	}
	
	@Override
	public Livreur updateLocation(Long id, Livreur livreur) {
		System.out.println("MMMMMMMMMMMMMMMMMMMMMMM********************");
		System.out.println(livreur);
		Livreur liv = livreurDao.findByEmail("livreur@livreur.com");
		 //.setLg(livreur.getLg());
		// liv.setLat(livreur.getLat());
	
		return livreurDao.save(liv);
	}

	@Override
	public Livreur findByNom(String nom) {
		return livreurDao.findByNom(nom);
	}

	@Override
	public Livreur findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livreur findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livreur findByEmail(String email) {
		// TODO Auto-generated method stub
		return livreurDao.findByEmail(email) ;
	}

}
