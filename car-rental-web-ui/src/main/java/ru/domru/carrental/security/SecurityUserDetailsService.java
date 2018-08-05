package ru.domru.carrental.security;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.domru.carrental.domain.system.User;
import ru.domru.carrental.domain.system.UserService;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	private static Logger log = LoggerFactory.getLogger(SecurityUserDetailsService.class);
	
	@Autowired
	UserService userService;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByUsername(username);
		
		if(null==user) throw new UsernameNotFoundException("Username not found" + username);
		
		userService.setCurrentUser(user);

		List<GrantedAuthority> authorities = 
				user.getRoleList().stream()
				.map(role->new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		
		
        return new org.springframework
        		.security.core.userdetails.User(username, user.getPassword(), authorities);
        
	}

}
