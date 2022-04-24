package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Roles.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("RolesRepository")
public interface RolesRepository extends JpaRepository<RolesEntity, Serializable> {
}
