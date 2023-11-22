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
 * UTILIZANDO CORS , ahora se puede consumir por ejemplo angular (otro servidor)
 * admin sin clave codificada
 user: ddaviddya@gmail.com
 clave:12345678
 
 user con clave codificada
 user: davidyallerco@gmail.com
 clave: 12345678 
 
 
 Se esta conectando a la BD customizada
 
 se cambio la bd db_seguridad6_2
 
 se actualizo la DB las claves otra vez sin codificar
 */
