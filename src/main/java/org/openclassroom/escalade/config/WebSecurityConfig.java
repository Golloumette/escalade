package org.openclassroom.escalade.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	// configurer DataSource dataSource=new JpaConfig.dataSource;
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		auth
		.jdbcAuthentication()
			.dataSource(dataSource)
			.withDefauLtSchema()
			.withUser("user").password("password").roles("USER").and()
			.withUser("admin").password("password").roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http
		 .authorizeRequests()
		 // donne les permissions .antMatchers("/admin/**").hasRole("ADMIN")
		    .anyRequest()
		      .authenticated()
		        .and()
		        //ou .httpBasic();
		   .formLogin()
		     .loginPage("/escalade/accueil.html")
		     .permitAll();
	}
	protected void configure2(HttpSecurity http) throws Exception {
		http
			.logout()                                                                
				.logoutUrl("/my/logout")                                                 
				.logoutSuccessUrl("/my/index")                                          
				//.logoutSuccessHandler( logoutSuccessHandler)                              
				.invalidateHttpSession(true) ;                                            
				//.addLogoutHandler(logoutHandler)                                         
				//.deleteCookies(cookieNamesToClear)                                       
				//.and()
		
	}
	
	

}
