package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Repository("TBIContratosRespository")
public interface TBIContratosRespository extends JpaRepository<TBIContratosEntity, Serializable> {
}
