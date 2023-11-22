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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/loans", "/balance", "/accounts", "/cards")
				.authenticated().anyRequest().permitAll()).formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		 http.cors(cors -> corsConfigurationSource()); //-----------

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
