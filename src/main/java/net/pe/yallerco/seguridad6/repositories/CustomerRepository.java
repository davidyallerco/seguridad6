package net.pe.yallerco.seguridad6.repositories;


import org.springframework.data.repository.CrudRepository;
import net.pe.yallerco.seguridad6.entites.CustomerEntity;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByEmail(String email);
}
