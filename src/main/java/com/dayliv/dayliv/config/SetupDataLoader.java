package com.dayliv.dayliv.config;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dayliv.dayliv.dao.RoleDao;
import com.dayliv.dayliv.dao.UserDao;
import com.dayliv.dayliv.dto.SocialProvider;
import com.dayliv.dayliv.model.Role;
import com.dayliv.dayliv.model.User;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private boolean alreadySetup = false;

	@Autowired
	private UserDao userRepository;

	@Autowired
	private RoleDao roleRepository;

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
		Set<Role> rolesAdmin = new HashSet<>();
		rolesAdmin.add(userRole);
		rolesAdmin.add(adminRole);
		rolesAdmin.add(parRole);
		rolesAdmin.add(livRole);
		rolesAdmin.add(disRole);

	   createUserIfNotFound("admin@admin.com", "Admin", "admin", rolesAdmin);
		Set<Role> rolesPartenaire = new HashSet<>();
		rolesPartenaire.add(userRole);
		rolesPartenaire.add(parRole);
	   createUserIfNotFound("partenaire@partenaire.com", "Partenaire", "partenaire", rolesPartenaire);
		Set<Role> rolesLivreur = new HashSet<>();
		rolesLivreur.add(userRole);
		rolesLivreur.add(livRole);
	   createUserIfNotFound("livreur@livreur.com", "Livreur", "livreur", rolesLivreur);
		Set<Role> rolesDispatcher = new HashSet<>();
		rolesDispatcher.add(userRole);
		rolesDispatcher.add(disRole);
	   createUserIfNotFound("dispatcher@dispatcher.com", "Dispatcher", "dispatcher", rolesDispatcher);

		alreadySetup = true;
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