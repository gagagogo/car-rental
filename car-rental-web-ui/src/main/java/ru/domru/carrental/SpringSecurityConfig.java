package ru.domru.carrental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBindingFilter;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.csrf.CsrfFilter;

import ru.domru.carrental.domain.system.User;
import ru.domru.carrental.security.AjaxAuthenticationErrorHandler;
import ru.domru.carrental.security.SecurityUserDetailsService;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	SecurityUserDetailsService userDetailsService;
	
	@Autowired
	AjaxAuthenticationErrorHandler failureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
        CsrfTokenResponseHeaderBindingFilter csrfTokenFilter = new CsrfTokenResponseHeaderBindingFilter();
        http.addFilterAfter(csrfTokenFilter, CsrfFilter.class);
		
		
	    http.authorizeRequests()
	      .antMatchers("/css/**").permitAll()
          .antMatchers("/js/app-login.js").permitAll()
          .antMatchers("/lib/**").permitAll()
          .antMatchers("/lib/**").permitAll()
          .anyRequest().authenticated()
	      .and().formLogin()
	      .defaultSuccessUrl("/")
	      .loginProcessingUrl("/system/authenticate")
	      .loginPage("/login.html").permitAll()
	      .failureHandler(failureHandler)
	      .and()
	      .logout().logoutUrl("/logout");
	      
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new StandardPasswordEncoder());
	}
	
}
