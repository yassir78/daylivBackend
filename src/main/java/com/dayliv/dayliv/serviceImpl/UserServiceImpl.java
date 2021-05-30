package com.dayliv.dayliv.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dayliv.dayliv.dao.PartenaireDao;
import com.dayliv.dayliv.dao.RoleDao;
import com.dayliv.dayliv.dao.UserDao;
import com.dayliv.dayliv.dto.LocalUser;
import com.dayliv.dayliv.dto.SignUpRequest;
import com.dayliv.dayliv.dto.SocialProvider;
import com.dayliv.dayliv.exception.OAuth2AuthenticationProcessingException;
import com.dayliv.dayliv.exception.UserAlreadyExistAuthenticationException;
import com.dayliv.dayliv.model.Commande;
import com.dayliv.dayliv.model.Partenaire;
import com.dayliv.dayliv.model.Role;
import com.dayliv.dayliv.model.User;
import com.dayliv.dayliv.oauth2.user.OAuth2UserInfo;
import com.dayliv.dayliv.oauth2.user.OAuth2UserInfoFactory;
import com.dayliv.dayliv.service.CommandeService;
import com.dayliv.dayliv.service.UserService;
import com.dayliv.dayliv.util.GeneralUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userRepository;

	@Autowired
	private RoleDao roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private PartenaireDao partenaireDao;

	@Override
	@Transactional(value = "transactionManager")
	public User registerNewUser(final SignUpRequest signUpRequest) throws UserAlreadyExistAuthenticationException {
		if (signUpRequest.getUserID() != null && userRepository.existsById(signUpRequest.getUserID())) {
			throw new UserAlreadyExistAuthenticationException(
					"User with User id " + signUpRequest.getUserID() + " already exist");
		} else if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			throw new UserAlreadyExistAuthenticationException(
					"User with email id " + signUpRequest.getEmail() + " already exist");
		}
		User user = buildUser(signUpRequest);
		Date now = Calendar.getInstance().getTime();
		user.setCreatedDate(now);
		user.setModifiedDate(now);
		user = userRepository.save(user);
		userRepository.flush();
		return user;
	}

	private User buildUser(final SignUpRequest formDTO) {
		User user = new User();
		user.setDisplayName(formDTO.getDisplayName());
		user.setEmail(formDTO.getEmail());
		user.setPassword(passwordEncoder.encode(formDTO.getPassword()));
		final HashSet<Role> roles = new HashSet<Role>();
		roles.add(roleRepository.findByName(Role.ROLE_COSTUMER));
		user.setRoles(roles);
		user.setProvider(formDTO.getSocialProvider().getProviderType());
		user.setEnabled(true);
		user.setProviderUserId(formDTO.getProviderUserId());
		return user;
	}

	@Override
	public User findUserByEmail(final String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public LocalUser processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken,
			OidcUserInfo userInfo) {
		OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, attributes);
		if (StringUtils.isEmpty(oAuth2UserInfo.getName())) {
			throw new OAuth2AuthenticationProcessingException("Name not found from OAuth2 provider");
		} else if (StringUtils.isEmpty(oAuth2UserInfo.getEmail())) {
			throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
		}
		SignUpRequest userDetails = toUserRegistrationObject(registrationId, oAuth2UserInfo);
		User user = findUserByEmail(oAuth2UserInfo.getEmail());
		if (user != null) {
			if (!user.getProvider().equals(registrationId)
					&& !user.getProvider().equals(SocialProvider.LOCAL.getProviderType())) {
				throw new OAuth2AuthenticationProcessingException(
						"Looks like you're signed up with " + user.getProvider() + " account. Please use your "
								+ user.getProvider() + " account to login.");
			}
			user = updateExistingUser(user, oAuth2UserInfo);
		} else {
			user = registerNewUser(userDetails);
		}

		return LocalUser.create(user, attributes, idToken, userInfo);
	}

	private User updateExistingUser(User existingUser, OAuth2UserInfo oAuth2UserInfo) {
		existingUser.setDisplayName(oAuth2UserInfo.getName());
		return userRepository.save(existingUser);
	}

	private SignUpRequest toUserRegistrationObject(String registrationId, OAuth2UserInfo oAuth2UserInfo) {
		return SignUpRequest.getBuilder().addProviderUserID(oAuth2UserInfo.getId())
				.addDisplayName(oAuth2UserInfo.getName()).addEmail(oAuth2UserInfo.getEmail())
				.addSocialProvider(GeneralUtils.toSocialProvider(registrationId)).addPassword("changeit").build();
	}

	@Override
	public float getTotalVentesePaartenaire(Long id) {
		// TODO Auto-generated method stub
		Partenaire partenaire = partenaireDao.findById(id).get();
		List<Commande> commandes = commandeService.findAllByStoreCode(partenaire.getStoreCode());
		float revenue = 0;
		if (commandes == null || commandes.size() == 0) {
			return revenue;
		}
		// next of the method implementation
		return commandes.size();
	}

	@Override
	public float getTotalRevenuePaartenaire(Long id) {
		// TODO Auto-generated method stub
		Partenaire partenaire = partenaireDao.findById(id).get();
		List<Commande> commandes = commandeService.findAllByStoreCode(partenaire.getStoreCode());
		float total = 0;
		if (commandes != null && commandes.size() > 0) {
			for (Commande commande : commandes) {
				total += commande.getTotale_commande();
			}
		}
		// next of the method implementation
		return total;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User update(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
