package com.dayliv.dayliv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.PartenaireDao;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.service.PartenaireService;

@Service
public class PartenaireServiceImpl implements PartenaireService {
	@Autowired
    private PartenaireDao partenaireDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public List<Partenaire> findAll() {
		return partenaireDao.findAll();
	}
	@Override
	public Partenaire save(Partenaire partenaire) {
		String password =passwordEncoder.encode(partenaire.getPassword());
		partenaire.setPassword(password);
		return partenaireDao.save(partenaire);
	}
	@Override
	public void delete(Long id) {
		partenaireDao.deleteById(id);
	}
	@Override
	public Partenaire update(Long id, Partenaire partenaire) {
		return partenaireDao.save(partenaire);
	}
	@Override
	public Partenaire findByNom(String nom) {
		return partenaireDao.findByNom(nom);
	}
	@Override
	public Partenaire findById(Long id) {
		return partenaireDao.getOne(id);
	}
	@Override
	public Partenaire findByLogin(String login) {
		return partenaireDao.findByLogin(login);
	}

}
