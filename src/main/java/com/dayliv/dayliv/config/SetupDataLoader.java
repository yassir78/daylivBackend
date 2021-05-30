package com.dayliv.dayliv.config;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dayliv.dayliv.dao.RoleDao;
import com.dayliv.dayliv.dao.UserDao;
import com.dayliv.dayliv.dto.SocialProvider;
import com.dayliv.dayliv.model.Dispatcher;
import com.dayliv.dayliv.model.Livreur;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.Role;
import com.dayliv.dayliv.model.User;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	@Autowired
	private UserDao userRepository;

	@Autowired
	private RoleDao roleRepository;
    @Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if (alreadySetup) {
			return;
		}
		// Create initial roles
		Role userRole = createRoleIfNotFound(Role.ROLE_COSTUMER);
		Role adminRole = createRoleIfNotFound(Role.ROLE_ADMIN);
		Role parRole = createRoleIfNotFound(Role.ROLE_PARTENAIRE);
		Role disRole = createRoleIfNotFound(Role.ROLE_DISPATCHER);
		Role livRole = createRoleIfNotFound(Role.ROLE_LIVREUR);
		
		//User creation
		Set<Role> rolesAdmin = new HashSet<>();
		rolesAdmin.add(userRole);
		rolesAdmin.add(adminRole);
		//rolesAdmin.add(parRole);
		//rolesAdmin.add(livRole);
		//rolesAdmin.add(disRole);

	   createUserIfNotFound("admin@admin.com", "Admin", "admin", rolesAdmin);
		Set<Role> rolesPartenaire = new HashSet<>();
		rolesPartenaire.add(userRole);
		rolesPartenaire.add(parRole);
	   createPartenaireIfNotFound("partenaire@partenaire.com", "Partenaire", "partenaire", rolesPartenaire, "XEHZJ8855");
	   createPartenaireIfNotFound("ikea@ikea.com", "Ikea", "ikea", rolesPartenaire, "I2021");
	   createPartenaireIfNotFound("payot@payot.com", "Payot", "payot", rolesPartenaire, "P2021");

		Set<Role> rolesLivreur = new HashSet<>();
		rolesLivreur.add(userRole);
		rolesLivreur.add(livRole);
	   createUserIfNotFound("livreur@livreur.com", "Livreur", "livreur", rolesLivreur);
		Set<Role> rolesDispatcher = new HashSet<>();
		rolesDispatcher.add(userRole);
		rolesDispatcher.add(disRole);
	   createDispatcherIfNotFound("dispatcher@dispatcher.com", "Dispatcher", "dispatcher", rolesDispatcher);

		alreadySetup = true;
		
		
		//Livreur Creation
		
	   createLivreurIfNotFound("livreur1@livreur1.com", "Livreur1",6.2 ,46.2143907 ,"livreur1", "scooter",rolesLivreur);
	   createLivreurIfNotFound("livreur2@livreur2.com", "Livreur2",6.2493 , 46.2243907, "livreur2","camion" ,rolesLivreur);
//	   createLivreurIfNotFound("livreur3@livreur3.com", "Livreur3",6.3 ,46.2443907 , "livreur3", rolesLivreur);
//	   createLivreurIfNotFound("livreur4@livreur4.com", "Livreur4",6.3,46.2643907 , "livreur4", rolesLivreur);
//	   createLivreurIfNotFound("livreur5@livreur5.com", "Livreur5", 6.3,46.2743907 , "livreur5", rolesLivreur);
//	   createLivreurIfNotFound("livreur6@livreur6.com", "Livreur6", 6.3,46.2243907,"livreur6", rolesLivreur);

        
	}

	@Transactional
	private final User createLivreurIfNotFound(final String email, final String name,double lg, double lat, final String password,final String mobilite ,Set<Role> roles) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			Livreur livreur = new Livreur();
			livreur.setDisplayName(name);
			livreur.setLg(lg);
			livreur.setLat(lat);
			livreur.setEmail(email);
			livreur.setPassword(passwordEncoder.encode(password));
			livreur.setRoles(roles);
			livreur.setMobility(mobilite);
			livreur.setProvider(SocialProvider.LOCAL.getProviderType());
			livreur.setEnabled(true);
			Date now = Calendar.getInstance().getTime();
			livreur.setCreatedDate(now);
			livreur.setModifiedDate(now);
			
			user = userRepository.save(livreur);
		}

		return user;
	}

	
	@Transactional
	private final User createDispatcherIfNotFound(final String email, final String name, final String password, Set<Role> roles) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			Dispatcher dispatcher = new Dispatcher();
			dispatcher.setDisplayName(name);
			dispatcher.setEmail(email);
			dispatcher.setPassword(passwordEncoder.encode(password));
			dispatcher.setRoles(roles);
			dispatcher.setProvider(SocialProvider.LOCAL.getProviderType());
			dispatcher.setEnabled(true);
			Date now = Calendar.getInstance().getTime();
			dispatcher.setCreatedDate(now);
			dispatcher.setModifiedDate(now);
			user = userRepository.save(dispatcher);
		}

		return user;
	}
	
	
	@Transactional
	private final User createPartenaireIfNotFound(final String email, final String name, final String password, Set<Role> roles, String storeCode) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			Partenaire partenaire = new Partenaire();
			partenaire.setDisplayName(name);
			partenaire.setEmail(email);
			partenaire.setPassword(passwordEncoder.encode(password));
			partenaire.setRoles(roles);
			partenaire.setStoreCode(storeCode);
			partenaire.setProvider(SocialProvider.LOCAL.getProviderType());
			partenaire.setEnabled(true);
			Date now = Calendar.getInstance().getTime();
			partenaire.setCreatedDate(now);
			partenaire.setModifiedDate(now);
			user = userRepository.save(partenaire);
		}

		return user;
	}
	
	
	@Transactional
	private final User createUserIfNotFound(final String email, final String name, final String password, Set<Role> roles) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			user = new User();
			user.setDisplayName(name);
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode(password));
			user.setRoles(roles);
			user.setProvider(SocialProvider.LOCAL.getProviderType());
			user.setEnabled(true);
			Date now = Calendar.getInstance().getTime();
			user.setCreatedDate(now);
			user.setModifiedDate(now);
			user = userRepository.save(user);
		}

		return user;
	}
	@Transactional
	private final Role createRoleIfNotFound(final String name) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = roleRepository.save(new Role(name));
		}
		return role;
	}
}