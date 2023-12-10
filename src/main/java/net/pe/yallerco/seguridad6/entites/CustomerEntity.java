package net.pe.yallerco.seguridad6.entites;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "customers")
@Data
public class CustomerEntity implements Serializable {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @Column(name = "pwd")
    private  String password;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    private List<RoleEntity> roles;
	

}
