package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Repository("InmueblesRepository")
public interface InmueblesRepository extends JpaRepository<InmuebleEntity, Serializable> {
}
