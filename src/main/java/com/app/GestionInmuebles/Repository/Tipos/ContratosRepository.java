package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("ContratosRepository")
public interface ContratosRepository extends JpaRepository<ContratosEntity, Serializable> {
    List<ContratosEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    List<ContratosEntity> getByidTipoContrato(int id);
}

