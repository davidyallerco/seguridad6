package net.pe.yallerco.seguridad6.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
//import java.math.BigInteger;

@Entity
@Table(name = "customers")
@Data
public class CustomerEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Id
    private Integer id;
    private String email;
    @Column(name = "pwd")
    private  String password;
    @Column(name = "rol")
    private String role;
}
