package com.app.GestionInmuebles.Repository;


import com.app.GestionInmuebles.DTO.Tipos.Roles.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("RolesRepository")
public interface RolesRepository extends JpaRepository<RolesEntity, Serializable> {
    List<RolesEntity> findByAdministradorIdOrAdministradorId(int id, int especifico);

    List<RolesEntity> findAllByidRol(int id);
}
