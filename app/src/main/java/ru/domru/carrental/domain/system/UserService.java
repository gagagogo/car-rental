package ru.domru.carrental.domain.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
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
	
}
