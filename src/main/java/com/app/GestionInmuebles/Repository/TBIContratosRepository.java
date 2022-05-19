package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("TBIContratosRepository")
public interface TBIContratosRepository extends JpaRepository<TBIContratosEntity, Serializable> {
    List<TBIContratosEntity> getByadministradorId(int id);
    List<TBIContratosEntity> getByidContratos(int id);
}
