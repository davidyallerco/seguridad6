package net.pe.yallerco.seguridad6.security;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import net.pe.yallerco.seguridad6.security.CsrfCookieFilter;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		var requestHandler = new CsrfTokenRequestAttributeHandler();

		 requestHandler.setCsrfRequestAttributeName("_csrf");
		 http.authorizeHttpRequests(auth ->
         //auth.requestMatchers("/loans", "/balance", "/accounts", "/cards")
              auth
//                      .requestMatchers("/loans", "/balance").hasRole("USER")
//                      .requestMatchers("/accounts", "/cards").hasRole("ADMIN")
                    .requestMatchers("/loans").hasAuthority("VIEW_LOANS")
                      .requestMatchers("/balance").hasAuthority("VIEW_BALANCE")
                      .requestMatchers("/cards").hasAuthority("VIEW_CARDS")
                      .requestMatchers("/accounts").hasAnyAuthority("VIEW_ACCOUNT", "VIEW_CARDS")
                  .anyRequest().permitAll())
		.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		http.cors(cors -> corsConfigurationSource()); 

		http.csrf(csrf -> csrf.
				csrfTokenRequestHandler(requestHandler)
				.ignoringRequestMatchers("/welcome", "/about_us")
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
				.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);
		return http.build();
	}

	// nos ayuda para que funcione sin encriptacion
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	// Permitiendo que dominios puedes consultar a este servidor (
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		var config = new CorsConfiguration();

		// config.setAllowedOrigins(List.of("http://localhost:4200",
		// "http://my-app.com"));
		config.setAllowedOrigins(List.of("*"));
		// config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
		config.setAllowedMethods(List.of("*"));
		config.setAllowedHeaders(List.of("*"));

		var source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config); // quiero proteger toda la aplicacion con /**

		return source;
	}

}
