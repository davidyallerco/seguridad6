package net.pe.yallerco.seguridad6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity //aunque ahora ya lleva implicito
public class Seguridad6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seguridad6Application.class, args);
	}

	
}


/*
 user: david
 clave: 123456
 
 
 */
