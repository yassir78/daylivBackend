package com.dayliv.dayliv.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dayliv.dayliv.dao.PartenaireDao;
import com.dayliv.dayliv.dao.RoleDao;
import com.dayliv.dayliv.model.NotificationEmail;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.model.Role;
import com.dayliv.dayliv.service.PartenaireService;
import com.dayliv.dayliv.service.SendMailService;

@Service
public class PartenaireServiceImpl implements PartenaireService {
	@Autowired
    private PartenaireDao partenaireDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleDao roleRepository;

	@Autowired
    private  SendMailService mailService;
	@Override
	public List<Partenaire> findAll() {
		return partenaireDao.findAll();
	}
	@Override
	public Partenaire save(Partenaire partenaire) {
		String password =passwordEncoder.encode(partenaire.getPassword());
		final HashSet<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByName(Role.ROLE_PARTENAIRE));
		partenaire.setRoles(roles);
		//Send account creation notification email
		mailService.sendMail(new NotificationEmail("Dayliv MarketPlace",
				partenaire.getEmail(), "Création de votre compte" +
                "Vos informations de connexion sont:"+" Email : "+partenaire.getEmail()+" Mot de passe:"+partenaire.getPassword()));
		
		partenaire.setPassword(password);
		return partenaireDao.save(partenaire);
	}
	@Override
	public int delete(Long id) {
		partenaireDao.deleteById(id);
		return 1;
	}
	@Override
	public Partenaire update(Long id, Partenaire partenaire) {
		String password =passwordEncoder.encode(partenaire.getPassword());
		final HashSet<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByName(Role.ROLE_PARTENAIRE));
		partenaire.setRoles(roles);
		partenaire.setPassword(password);

		return partenaireDao.save(partenaire);
	}
	@Override
	public Partenaire findByNom(String nom) {
		return partenaireDao.findByNom(nom);
	}
	@Override
	public Partenaire findById(Long id) {
		return partenaireDao.findById(id).get();
	}
	@Override
	public Partenaire findByLogin(String login) {
		return partenaireDao.findByLogin(login);
	}
	@Override
	public Map<String, Object> getAllPartenaires(String name, int page, int size) {
		 List<Partenaire> partenaires = new ArrayList<Partenaire>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Partenaire> pagecats;
	      if (name == null)
	    	  pagecats = partenaireDao.findAll(paging);
	      else
	    	  pagecats = partenaireDao.findByNomContaining(name, paging);

	      partenaires = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("partenaires", partenaires);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
	}

}
