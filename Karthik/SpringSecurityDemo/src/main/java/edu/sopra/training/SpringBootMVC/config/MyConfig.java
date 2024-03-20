package edu.sopra.training.SpringBootMVC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		
		return provider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
//		http.csrf(c->c.disable());    //--------------------No Login Page
		
		http.authorizeHttpRequests(a->a.anyRequest().authenticated()); 
//		http.authorizeRequests().requestMatchers("/token/**").authenticated().requestMatchers("/names").permitAll();
		http.formLogin(Customizer.withDefaults());  //   ------LoginPage
		
		http.httpBasic(Customizer.withDefaults());		// --------PopUp Form page
//		http.sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //------SessionCreationPolicy Default->Always (Same session everytime you refresh until u logout), Stateless-> to create different session whenever u refresh
		
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userService() {
//		
//		UserDetails customer= User.withDefaultPasswordEncoder().username("cust").password("cust").roles("USER").build();
//		UserDetails admin= User.withDefaultPasswordEncoder().username("sawon").password("huha").roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(customer,admin);
//	}
	
	
}
