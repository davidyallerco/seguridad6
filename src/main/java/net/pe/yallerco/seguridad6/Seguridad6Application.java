package net.pe.yallerco.seguridad6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class Seguridad6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seguridad6Application.class, args);
	}

	
}


/*
 * admin
 user: ddaviddya@gmail.com
 clave: 12345678
 
 user
 user: davidyallerco@gmail.com
 clave: 12345678
 
 
 Se esta conectando a la BD customizada
 
 se cambio la bd db_seguridad6_2
 */
