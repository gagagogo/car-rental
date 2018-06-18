package ru.domru.carrental.domain.system;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for User entity
 * */

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public DataTablesOutput<User> getUserList(DataTablesInput input){
		return userRepository.findAll(input);
	}
	
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User findUserByUsername(String username) {
		return userRepository.findUserByName(username);
	}
	
	public User getCurrentUser() throws AuthenticationException {
		String username = SecurityContextHolder.getContext().getAuthentication().getName(); 
		User user =  findUserByUsername(username);
		if(user==null) throw new AuthenticationException("You are currently not authorized");
		user.setPassword("********");
		return user;
	}
	 
	
}
