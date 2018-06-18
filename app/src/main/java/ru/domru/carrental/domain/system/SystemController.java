package ru.domru.carrental.domain.system;

import javax.validation.Valid;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;


@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	UserService userService;
		
	@JsonView(DataTablesOutput.View.class)
	@RequestMapping(value="/user/list")	
	public DataTablesOutput<User> getUserList(@Valid DataTablesInput input) {
		return userService.getUserList(input);
	}
	
	@RequestMapping(value="/user/create")
	public User userCteate(@Valid User user) {
		return userService.save(user);
	}
	
	@RequestMapping(value="/currentuser")
	public User currentuser() throws AuthenticationException {
		return userService.getCurrentUser();
	}

	
}