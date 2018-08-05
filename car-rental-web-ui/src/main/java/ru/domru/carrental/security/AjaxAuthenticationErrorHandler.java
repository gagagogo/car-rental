package ru.domru.carrental.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AjaxAuthenticationErrorHandler implements AuthenticationFailureHandler {

	private AuthenticationFailureHandler defaultHendler;
	
	@Autowired
	private MappingJackson2HttpMessageConverter springMvcJacksonConverter;
	
	public AjaxAuthenticationErrorHandler() {
		this.defaultHendler = new SimpleUrlAuthenticationFailureHandler();
	}

	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		
		if("true".equals(request.getHeader("X-Login-Ajax-call"))) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
            ex.setStackTrace(new StackTraceElement[] {});
            String json = springMvcJacksonConverter.getObjectMapper().writeValueAsString(ex);
            
            response.getWriter().write(json);
            
			
		}else {
			this.defaultHendler.onAuthenticationFailure(request, response, ex);
		}

	}

}
