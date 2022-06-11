
package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository("IngresoGastoRepository")
public interface IngresoGastoRepository extends JpaRepository<IngresoGastoEntity, Serializable> {
    List<IngresoGastoEntity> findByAdministradorIdOrderByFechaFacturaDesc(int idAdministrador);
    List<IngresoGastoEntity> findByIdInGa(int idInGa);
    List<IngresoGastoEntity> findByAdministradorId(int administradorId);
    List<IngresoGastoEntity> findByAdministradorIdAndFechaPagoIsNull(int administradorId);

    @Query(value = "SELECT inga.* " +
            "FROM ingreso_gasto as inga " +
            "JOIN inmuebles as inmu " +
            "ON inga.inmueble_id = inmu.id_inmueble " +
            "JOIN tbi_contratos as contratos " +
            "ON contratos.id_inmueble = inmu.id_inmueble " +
            "JOIN tbi_intervinientes  " +
            "ON tbi_intervinientes.tbi_contratos_id = contratos.contrato_id " +
            "JOIN clientes  " +
            "ON clientes.id_cliente = tbi_intervinientes.cliente_id " +
            "WHERE inga.administrador_id = ? " +
            "AND clientes.id_cliente = ? " +
            "GROUP BY inga.id_ingreso_gasto " +
            "ORDER BY inga.fecha_factura DESC", nativeQuery = true)
    List<IngresoGastoEntity> findByEntidadOrderByFecha(int administradorId, int entidadId);

    @Query("select i from IngresoGastoEntity i where i.administradorId = ?1 order by i.fechaFactura DESC")
    List<IngresoGastoEntity> obtencionFecha(int administradorId);
    @Query(value = "SELECT SUM(inga2.total_gasto) AS total_gasto, " +
            "SUM(inga2.total_ingreso) AS total_ingreso, " +
            "SUM(inga2.total_ingreso) - SUM(inga2.total_gasto) AS total_balance, " +
            "inga2.inmueble_id, " +
            "inga2.alias " +
            "FROM (SELECT inga.total_gasto, " +
            "inga.total_ingreso, " +
            "inga.inmueble_id, " +
            "inmu.id_inmueble, " +
            "inmu.alias, " +
            "EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            "EXTRACT(MONTH FROM inga.fecha_factura) AS mes  " +
            "FROM ingreso_gasto AS inga  " +
            "JOIN inmuebles AS inmu  " +
            "ON inga.inmueble_id = inmu.id_inmueble  " +
            "JOIN tbi_contratos AS contratos  " +
            "ON contratos.id_inmueble = inmu.id_inmueble  " +
            "JOIN tbi_intervinientes AS intervinientes  " +
            "ON intervinientes.tbi_contratos_id = contratos.contrato_id  " +
            "JOIN clientes AS cl  " +
            "ON intervinientes.cliente_id = cl.id_cliente  " +
            "WHERE cl.id_cliente = ?) as inga2  " +
            "GROUP BY inga2.alias,  " +
            "inga2.inmueble_id", nativeQuery = true)
    List<String> findInformeXInmueble(int idEntidad);
    @Query(value = "SELECT SUM(inga2.total_gasto) AS total_gasto, " +
            "SUM(inga2.total_ingreso) AS total_ingreso, " +
            "SUM(inga2.total_ingreso) - SUM(inga2.total_gasto) AS total_balance, " +
            "inga2.inmueble_id, " +
            "inga2.alias, " +
            "inga2.anio " +
            "FROM (SELECT inga.total_gasto, " +
            "inga.total_ingreso, " +
            "inga.inmueble_id, " +
            "inmu.id_inmueble, " +
            "inmu.alias, " +
            "EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            "EXTRACT(MONTH FROM inga.fecha_factura) AS mes  " +
            "FROM ingreso_gasto AS inga  " +
            "JOIN inmuebles AS inmu  " +
            "ON inga.inmueble_id = inmu.id_inmueble  " +
            "JOIN tbi_contratos AS contratos  " +
            "ON contratos.id_inmueble = inmu.id_inmueble  " +
            "JOIN tbi_intervinientes AS intervinientes  " +
            "ON intervinientes.tbi_contratos_id = contratos.contrato_id  " +
            "JOIN clientes AS cl  " +
            "ON intervinientes.cliente_id = cl.id_cliente  " +
            "WHERE inmu.id_inmueble = ?) as inga2  " +
            "GROUP BY inga2.alias,  " +
            "inga2.inmueble_id,  " +
            "inga2.anio", nativeQuery = true)
    List<String> findInformeByInmuebleXAnios(int idInmueble);
    @Query(value = "SELECT SUM(inga2.total_gasto) AS total_gasto, " +
            "SUM(inga2.total_ingreso) AS total_ingreso, " +
            "SUM(inga2.total_ingreso) - SUM(inga2.total_gasto) AS total_balance, " +
            "inga2.inmueble_id, " +
            "inga2.alias, " +
            "inga2.anio, " +
            "inga2.mes " +
            "FROM (SELECT inga.total_gasto, " +
            "inga.total_ingreso, " +
            "inga.inmueble_id, " +
            "inmu.id_inmueble, " +
            "inmu.alias, " +
            "EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            "EXTRACT(MONTH FROM inga.fecha_factura) AS mes  " +
            "FROM ingreso_gasto AS inga  " +
            "JOIN inmuebles AS inmu  " +
            "ON inga.inmueble_id = inmu.id_inmueble  " +
            "JOIN tbi_contratos AS contratos  " +
            "ON contratos.id_inmueble = inmu.id_inmueble  " +
            "JOIN tbi_intervinientes AS intervinientes  " +
            "ON intervinientes.tbi_contratos_id = contratos.contrato_id  " +
            "JOIN clientes AS cl  " +
            "ON intervinientes.cliente_id = cl.id_cliente  " +
            "WHERE inmu.id_inmueble = ?1) as inga2  " +
            "WHERE inga2.anio = ?2 " +
            "GROUP BY inga2.alias,  " +
            "inga2.inmueble_id,  " +
            "inga2.anio,  " +
            "inga2.mes", nativeQuery = true)
    List<String> findInformeByInuebleAnioXMes(int idInmueble, int anio);

    @Query("select i from IngresoGastoEntity i where i.totalImpuestoIva = ?1")
    List<IngresoGastoEntity> findByTotalImpuestoIva(float totalImpuestoIva);
}
