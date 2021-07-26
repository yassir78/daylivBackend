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

import com.dayliv.dayliv.dao.DispatcherDao;
import com.dayliv.dayliv.dao.RoleDao;
import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.model.NotificationEmail;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.Product;
import com.dayliv.dayliv.model.Role;
import com.dayliv.dayliv.service.DispatcherService;
import com.dayliv.dayliv.service.SendMailService;

@Service
public class DispatcherServiceImpl implements DispatcherService {
	@Autowired
	private DispatcherDao DispatcherDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleDao roleRepository;
	@Autowired
    private  SendMailService mailService;
	@Override
	public List<Dispatcher> findAll() {
		// TODO Auto-generated method stub
		return DispatcherDao.findAll();
	}

	@Override
	public Dispatcher save(Dispatcher dispatcher) {
		// TODO Auto-generated method stub
		String password = passwordEncoder.encode(dispatcher.getPassword());
		final HashSet<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByName(Role.ROLE_DISPATCHER));
		dispatcher.setRoles(roles);
		//Send account creation notification email
		mailService.sendMail(new NotificationEmail("Dayliv MarketPlace",
				dispatcher.getEmail(), "Création de votre compte" +
                "Vos informations de connexion sont:"+" Email : "+dispatcher.getEmail()+" Mot de passe:"+dispatcher.getPassword()));
		dispatcher.setPassword(password);
		return DispatcherDao.save(dispatcher);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
				DispatcherDao.deleteById(id);
				return 1;
	}

	@Override
	public Dispatcher update(Long id, Dispatcher dispatcher) {
		Dispatcher myDispatcher = DispatcherDao.findById(id).get();
		if(dispatcher.getPassword() != null) {
			String password =passwordEncoder.encode(dispatcher.getPassword());
			myDispatcher.setPassword(password);
		}
		if(dispatcher.getNom()!=null) {
			myDispatcher.setNom(dispatcher.getNom());
		}
		if(dispatcher.getPrenom() != null) {
			myDispatcher.setPrenom(dispatcher.getPrenom());
		}
		 if(dispatcher.getAdresse() !=null)
		 {
			 myDispatcher.setAdresse(dispatcher.getAdresse());
		 }
		 
		 if(dispatcher.getCodePostal()!=null) {
			 myDispatcher.setCodePostal(dispatcher.getCodePostal());
		 }
		 if(dispatcher.getEmail() !=null) {
			 myDispatcher.setEmail(dispatcher.getEmail());
		 }
		 
		 if(dispatcher.getDisplayName() !=null) {
			 myDispatcher.setDisplayName(dispatcher.getDisplayName());
		 }
		 
		 if(dispatcher.getNum_tel() !=null) {
			 myDispatcher.setNum_tel(dispatcher.getNum_tel());
		 }
		 if(dispatcher.getImage_profile() !=null) {
			 myDispatcher.setImage_profile(dispatcher.getImage_profile());
		 }
	     if(dispatcher.getCreatedDate() !=null) {
	    	 myDispatcher.setCreatedDate(dispatcher.getCreatedDate());
	     }
	     
	     if(dispatcher.getStoreCode() != null ) {
	    	 myDispatcher.setStoreCode(dispatcher.getStoreCode());
	     }
	     
		
		if(dispatcher.getRoles() !=null) {
			final HashSet<Role> roles = new HashSet<Role>();
			roles.add(roleRepository.findByName(Role.ROLE_PARTENAIRE));
			myDispatcher.setRoles(roles);

		}
		return DispatcherDao.save(myDispatcher);
	}

	@Override
	public Dispatcher findByNom(String nom) {
		// TODO Auto-generated method stub
		return DispatcherDao.findByNom(nom);
	}

	@Override
	public Dispatcher findById(Long id) {
		// TODO Auto-generated method stub
		return DispatcherDao.findById(id).get();
	}

	@Override
	public Dispatcher findByLogin(String login) {
		// TODO Auto-generated method stub
		return DispatcherDao.findByLogin(login);
	}

	@Override
	public Map<String, Object> getAllDispatchers(String name, int page, int size) {
		 List<Dispatcher> dispatchers = new ArrayList<Dispatcher>();
	      Pageable paging = PageRequest.of(page, size);
	      
	      Page<Dispatcher> pagecats;
	      if (name == null)
	    	  pagecats = DispatcherDao.findAll(paging);
	      else
	    	  pagecats = DispatcherDao.findByNomContaining(name, paging);

	      dispatchers = pagecats.getContent();

	      Map<String, Object> response = new HashMap<>();
	      response.put("dispatchers", dispatchers);
	      response.put("currentPage", pagecats.getNumber());
	      response.put("totalItems", pagecats.getTotalElements());
	      response.put("totalPages", pagecats.getTotalPages());

		return response;
	}

}
