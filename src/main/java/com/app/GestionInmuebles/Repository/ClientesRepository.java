package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Clientes.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("ClientesRepository")
public interface ClientesRepository extends JpaRepository<ClientesEntity, Serializable> {
}
