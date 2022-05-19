package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("ContratosRepository")
public interface ContratosRepository extends JpaRepository<ContratosEntity, Serializable> {
    List<ContratosEntity> getByadministradorId(int id);

    List<ContratosEntity> getByidTipoContrato(int id);
}

