package ru.domru.carrental.domain.system;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/login")
	public User login() {
		return new User();
	}
	
	/*http://localhost:8080/system/user/list?
		draw=1&
		columns[0][data]=idUser
		&columns[0][name]=
		&columns[0][searchable]=true
		&columns[0][orderable]=true
		&columns[0][search][value]=&
		columns[0][search][regex]=false
		&columns[1][data]=name&columns[1][name]=
		&columns[1][searchable]=true
		&columns[1][orderable]=true
		&columns[1][search][value]=
		&columns[1][search][regex]=false
		&columns[2][data]=descr
		&columns[2][name]=
		&columns[2][searchable]=true
		&columns[2][orderable]=true
		&columns[2][search][value]=
		&columns[2][search][regex]=false
		&order[0][column]=0
		&order[0][dir]=asc
		&start=0
		&length=10
		&search[value]=
		&search[regex]=false
		&_=1528901158445*/
	
	@RequestMapping("/user/list")
	public Page<User> userList(
			@RequestParam Optional<Integer> length, @RequestParam Optional<Integer> start) {

		int page = start.orElse(0)/length.orElse(10);

		return userRepository.findAll(PageRequest.of(page, length.orElse(10)));
	}

}
