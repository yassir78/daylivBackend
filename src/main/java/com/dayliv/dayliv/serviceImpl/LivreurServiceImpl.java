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

import com.dayliv.dayliv.dao.LivreurDao;
import com.dayliv.dayliv.dao.RoleDao;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.NotificationEmail;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.model.Role;
import com.dayliv.dayliv.service.LivreurService;
import com.dayliv.dayliv.service.SendMailService;

@Service
public class LivreurServiceImpl implements LivreurService {
	@Autowired
	private LivreurDao livreurDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleDao roleRepository;
	@Autowired
    private  SendMailService mailService;
	@Override
	public List<Livreur> findAll() {
		return livreurDao.findAll();
	}

	@Override
	public Livreur save(Livreur livreur) {
		final HashSet<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByName(Role.ROLE_LIVREUR));
		livreur.setRoles(roles);
		//Send account creation notification email
		mailService.sendMail(new NotificationEmail("Dayliv MarketPlace",
				livreur.getEmail(), "Création de votre compte" +
                "Vos informations de connexion sont:"+" Email : "+livreur.getEmail()+" Mot de passe:"+livreur.getPassword()));
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
		return livreurDao.findById(id).get();
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

	@Override
	public Map<String, Object> getAllLivreurs(String name, int page, int size) {
		 List<Livreur> livreurs = new ArrayList<Livreur>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Livreur> pagecats;
	      if (name == null)
	    	  pagecats = livreurDao.findAll(paging);
	      else
	    	  pagecats = livreurDao.findByNomContaining(name, paging);

	      livreurs = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("livreurs", livreurs);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
	}

}
