
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

    @Query("select i from IngresoGastoEntity i where i.administradorId = ?1 order by i.fechaFactura DESC")
    List<IngresoGastoEntity> obtencionFecha(int administradorId);
    @Query(value = "SELECT " +
            "sum(inga.total_gasto) as total_gasto,   " +
            "sum(inga.total_ingreso) as total_ingreso,   " +
            "sum(inga.total_ingreso) - sum(inga.total_gasto) as total_balance,   " +
            "inga.inmueble_id,   " +
            "inmu.alias,   " +
            "EXTRACT(YEAR FROM inga.fecha_factura) AS anio,    " +
            "MONTHNAME(MONTH ( inga.fecha_factura)) AS mes," +
            "TO_CHAR(inga.fecha_factura, 'Month') AS \"Month\"    " +
//            "(EXTRACT(MONTH FROM inga.fecha_factura))    " +
            "FROM ingreso_gasto AS inga     " +
            "JOIN inmuebles AS inmu      " +
            "ON inga.inmueble_id = inmu.id_inmueble     " +
            "JOIN tbi_contratos AS contratos    " +
            "ON contratos.id_inmueble = inmu.id_inmueble    " +
            "JOIN tbi_intervinientes AS intervinientes    " +
            "ON intervinientes.tbi_contratos_id = contratos.contrato_id    " +
            "JOIN clientes AS cl    " +
            "ON intervinientes.cliente_id = cl.id_cliente    " +
            "WHERE inga.administrador_id = ?   " +
            "AND cl.id_cliente = ?   " +
            "AND inga.borrado is false    " +
            "group by inga.inmueble_id,    " +
            "inmu.alias,    " +
            "inga.fecha_factura", nativeQuery = true)
    List<String> findInformeXInmueble(int idAdministrador, int idEntidad);
    @Query(value = "SELECT  " +
            "    SUM(inga.total_gasto) AS total_gasto, " +
            "    SUM(inga.total_ingreso) AS total_ingreso, " +
            "    SUM(inga.total_ingreso) - SUM(inga.total_gasto) AS total_balance, " +
            "    inga.inmueble_id, " +
            "    inmu.alias, " +
            "    EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            "TO_CHAR(inga.fecha_factura, 'Month') AS \"Month\"    " +
//            "    MONTHNAME(inga.fecha_factura) AS mes, " +
            " (EXTRACT(MONTH FROM inga.fecha_factura))    " +
            "FROM ingreso_gasto AS inga " +
            "JOIN inmuebles AS inmu " +
            "ON inga.inmueble_id = inmu.id_inmueble " +
            "WHERE inga.inmueble_id = 1 " +
            "AND inga.administrador_id = 2 " +
            "AND inga.borrado IS FALSE " +
            "GROUP BY EXTRACT(YEAR FROM inga.fecha_factura) , inga.inmueble_id , inmu.alias , inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByInmuebleXAnios(int idInmueble, int administradorId);
    @Query(value = "SELECT " +
            " sum(inga.total_gasto) as total_gasto," +
            " sum(inga.total_ingreso) as total_ingreso," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto) as total_balance," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(inga.fecha_factura, 'Month') AS \"Month\" " +
//            "    MONTHNAME(inga.fecha_factura) AS mes, " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu" +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.inmueble_id = ?" +
            " AND EXTRACT(YEAR FROM inga.fecha_factura) = ?" +
            " AND inga.administrador_id = ? " +
            " AND inga.borrado is false " +
            " group by EXTRACT(MONTH FROM inga.fecha_factura), " +
            " inga.inmueble_id, " +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByInuebleAnioXMes(int idInmueble, int anio, int administradorId);
    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id," +
            " EXTRACT(YEAR FROM inga.fecha_factura)) " +
            " sum(inga.total_gasto) as total_gasto," +
            " sum(inga.total_ingreso) as total_ingreso," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto) as total_balance," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(inga.fecha_factura, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu " +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.administrador_id = ? " +
            " AND inga.borrado is false " +
            " group by EXTRACT(YEAR FROM inga.fecha_factura), " +
            " inga.inmueble_id, " +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeXAnios(int administradorId);
    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id," +
            " EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " sum(inga.total_gasto) as total_gasto," +
            " sum(inga.total_ingreso) as total_ingreso," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto) as total_balance," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(inga.fecha_factura, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu" +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.administrador_id = ?" +
            " AND EXTRACT(YEAR FROM inga.fecha_factura) = ? " +
            " AND inga.borrado is false " +
            " group by EXTRACT(MONTH FROM inga.fecha_factura), " +
            " inga.inmueble_id, " +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByAniosXMeses(int administradorId, int anio);
    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id " +
            " sum(inga.total_gasto) as total_gasto," +
            " sum(inga.total_ingreso) as total_ingreso," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto) as total_balance," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(inga.fecha_factura, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu" +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.administrador_id = ?" +
            " AND EXTRACT(YEAR FROM inga.fecha_factura) = ?" +
            " AND EXTRACT(MONTH FROM inga.fecha_factura) = ? " +
            " AND inga.borrado is false " +
            " group by inga.inmueble_id," +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByAniosMesesXInmuebles(int administradorId, int anio, int mes);

    @Query("select i from IngresoGastoEntity i where i.totalImpuestoIva = ?1")
    List<IngresoGastoEntity> findByTotalImpuestoIva(float totalImpuestoIva);
}
