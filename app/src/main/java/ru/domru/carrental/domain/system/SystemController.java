package ru.domru.carrental.domain.system;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/list")	
	public DataTablesOutput<User> getUserList(@Valid DataTablesInput input) {
		return userService.getUserList(input);
	}
	
	@RequestMapping(value="/user/save")
	public User userSave(@RequestBody @Valid User user) {
		return userService.save(user);
	}
	
	@RequestMapping(value="/user/{idUser}", method=RequestMethod.GET)
	public User getUser(@PathVariable int idUser) {
		Optional<User> user = userService.getUser(idUser);
		if(!user.isPresent()) throw new EntityNotFoundException("Ivalid user id");
		return user.get();		
	}

	
}