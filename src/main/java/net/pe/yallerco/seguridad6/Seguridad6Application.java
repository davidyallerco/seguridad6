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
 user: admin
 clave: to_be_encoded
 
 user: user
 clave: to_be_encoded
 
 en este escenario se arreglo con PassworEncoder para
 hacer pasar la clave sin encriptar
 Spring exige que este encriptado.
 
 */
