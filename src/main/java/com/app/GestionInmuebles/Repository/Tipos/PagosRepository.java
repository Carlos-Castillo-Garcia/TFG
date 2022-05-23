package com.app.GestionInmuebles.Repository.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("PagosRepository")
public interface PagosRepository extends JpaRepository<PagosEntity, Serializable> {
    List<PagosEntity> findByAdministradorIdOrAdministradorId(int idGeneral, int idEspecifico);

    List<PagosEntity> findByIdTipoPago(int idPagos);

}
