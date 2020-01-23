//package it.mainp.configurations;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	};
//	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		
//		UserBuilder users = User.builder();
//		
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		
//		manager.createUser(
//				users
//				.username("Alessandro")
//				.password(new BCryptPasswordEncoder().encode("123Stella"))
//				.roles("USER")
//				.build());
//		manager.createUser(
//				users
//				.username("Admin")
//				.password(new BCryptPasswordEncoder().encode("VerySecretPwd"))
//				.roles("USER", "ADMIN")
//				.build());
//		return manager;
//	}
//	
//	
//	@Override
//	public void configure (final AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.userDetailsService(userDetailsService())
//		.passwordEncoder(passwordEncoder());
//	
//}
//	private static final String[] ADMIN_CLIENTI_MATCHER = 
//		{
//				"/utente/nuovo"
//		};
//	
//	
//	
//	@Override
//	protected void configure (final HttpSecurity http) throws Exception {
//		
//		http
//		.authorizeRequests()
//		.antMatchers("/utente/login/**").permitAll()
//		.antMatchers(ADMIN_CLIENTI_MATCHER).access("hasRole('Admin')")
//		.antMatchers("/comuni/**").hasRole("USER")
//		.and()
//			.formLogin()
//				.loginProcessingUrl("/utente/login")
//					.usernameParameter("username")
//					.passwordParameter("password")
//		.and()
//		.logout();
//	}
//}
