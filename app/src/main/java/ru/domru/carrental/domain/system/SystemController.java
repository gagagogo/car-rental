package ru.domru.carrental.domain.system;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {
	
	@RequestMapping("/login")
	public User login() {
		return new User();
	}

}
