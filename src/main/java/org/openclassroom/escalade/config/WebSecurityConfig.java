package org.openclassroom.escalade.config;



import org.openclassroom.escalade.business.impl.UserDetailsImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsImplService();
	    }

	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    };

	@Autowired
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		
		
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		System.out.println("test spring ");
		http.authorizeRequests()
		   .antMatchers("/utilisateur/liste.html").hasAnyRole("ASSO")
           .antMatchers("/**").permitAll();
           
    
	
		 
	}
	
	

}
