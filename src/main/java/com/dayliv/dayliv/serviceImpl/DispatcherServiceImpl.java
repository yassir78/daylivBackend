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
		String password =passwordEncoder.encode(dispatcher.getPassword());
		dispatcher.setPassword(password);
		final HashSet<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByName(Role.ROLE_DISPATCHER));
		dispatcher.setRoles(roles);
		//Send account creation notification email
				mailService.sendMail(new NotificationEmail("Please Activate your Account",
						dispatcher.getEmail(), "Thank you for signing up to Spring Dayliv, " +
		                "please click on the below url to activate your account : " +
		                "http://localhost:8080/api/auth/accountVerification/"+"token"));
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
		// TODO Auto-generated method stub
		return DispatcherDao.save(dispatcher);
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
