package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("TBIContratosRepository")
public interface TBIContratosRepository extends JpaRepository<TBIContratosEntity, Serializable> {
}
