package ru.domru.carrental.domain.system;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;


@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/login")
	public User login() {
		return new User();
	}
	
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/user/list")	
	public DataTablesOutput<User> userList(@Valid DataTablesInput input) {
		return userRepository.findAll(input);
	}
	
	@RequestMapping(value="/user/create")
	public User userCteate(@Valid User user) {
		return userRepository.save(user);
	}

}