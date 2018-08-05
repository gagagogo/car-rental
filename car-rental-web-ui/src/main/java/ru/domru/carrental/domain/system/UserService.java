package ru.domru.carrental.domain.system;

import java.util.Optional;

import org.apache.tomcat.websocket.AuthenticationException;
import org.hibernate.envers.boot.internal.EnversServiceInitiator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for User entity
 * */

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CurrentUser currentUser;
	
	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	private StandardPasswordEncoder encoder = new StandardPasswordEncoder();

	@Transactional
	public DataTablesOutput<User> getUserList(DataTablesInput input){
		return userRepository.findAll(input);
	}

	/**
	 * Save user enity and encode plane password to sha255 hash
	 * @return saved User entity
	 * */
	@Transactional
	public User save(User user) {
		String heshedPass = encoder.encode(user.getPassword());
		user.setPassword(heshedPass);
		user = userRepository.save(user);
		return user;
	}
	
	@Transactional(readOnly = true)
	public User findUserByUsername(String username) {
		return userRepository.findUserByName(username);
	}
	
	/*@Transactional(readOnly = true)
	public User getCurrentUser() throws AuthenticationException {
		String username = SecurityContextHolder.getContext().getAuthentication().getName(); 
		User user =  findUserByUsername(username);
		if(user==null) throw new AuthenticationException("You are currently not authorized");
		return user;
	}*/
	
	@Transactional(readOnly = true)
	public Optional<User> getUser(int idUser){
		return userRepository.findById(idUser);
	}

	public User getCurrentUser() throws AuthenticationException {
		
		if(currentUser.getUser()==null) {
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			setCurrentUser(findUserByUsername(userName));
			if(null==currentUser.getUser())throw new AuthenticationException("Cant't get cureent user. You are currently not authorized");
		}
		
		return currentUser.getUser();
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser.setUser(currentUser);
	}
	
}
