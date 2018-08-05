package ru.domru.carrental.audit;

import org.apache.tomcat.websocket.AuthenticationException;
import org.hibernate.envers.RevisionListener;
import org.springframework.context.ApplicationContext;

import ru.domru.carrental.ApplicationContextProvider;
import ru.domru.carrental.domain.system.UserService;

public class UserRevisionListener implements RevisionListener {

	UserService userService;
	
	@Override
	public void newRevision(Object userRevision) {
		
		if(userService==null) init();
		
		UserRevision entity = (UserRevision)userRevision;
		try {
			entity.setIdUser(userService.getCurrentUser().getIdUser());
		} catch (AuthenticationException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	private void init() {
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		userService  = (UserService)context.getBean("userService");    
	}

}