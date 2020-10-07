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
	 // hasher le mot de passe
	    public BCryptPasswordEncoder passwordEncoder() {
		 System.out.println("hasher le mdp");
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
		  .antMatchers("/topo/mestopos.html").hasAnyRole("ASSO","USER")
		  .antMatchers("/site/edit.html").hasAnyRole("ASSO","USER")
		  .antMatchers("/topo/liste.html").hasAnyRole("ASSO","USER")
		  .antMatchers("/commentaire/edit.html").hasAnyRole("ASSO","USER")
		  
           .antMatchers("/**").permitAll()
           .and()
           .formLogin().loginPage("/login.html")
           .successHandler(successHandler())
           .permitAll()
           .defaultSuccessUrl("/")
           .and()
           .logout().invalidateHttpSession(true)
           .logoutUrl("/logout.html")
           .logoutSuccessUrl("/accueil.html")
           .and()
           .csrf().disable();
          
    
		 
	}
	
	@Bean
	public CustomSuccessHandler successHandler() {
	    return new CustomSuccessHandler();
	}

	
	

}
