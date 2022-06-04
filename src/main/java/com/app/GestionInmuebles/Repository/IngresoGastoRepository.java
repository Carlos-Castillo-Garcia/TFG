
package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("IngresoGastoRepository")
public interface IngresoGastoRepository extends JpaRepository<IngresoGastoEntity, Serializable> {
    List<IngresoGastoEntity> findByAdministradorIdOrderByFechaFacturaDesc(int idAdministrador);

    List<IngresoGastoEntity> findByIdInGa(int idInGa);

    @Query("select i from IngresoGastoEntity i where i.administradorId = ?1 order by i.fechaFactura DESC")
    List<IngresoGastoEntity> obtencionFecha(int administradorId);

    List<IngresoGastoEntity> findByAdministradorId(int administradorId);

    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id, " +
            " inga.fecha_factura) " +
            " sum(inga.total_gasto)," +
            " sum(inga.total_ingreso)," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto)," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(CURRENT_TIMESTAMP, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu " +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.administrador_id = ? " +
            " AND inga.borrado is false " +
            " group by inga.inmueble_id, " +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeXInmueble(int idAdministrador);

    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id, " +
            " inga.fecha_factura) " +
            " sum(inga.total_gasto)," +
            " sum(inga.total_ingreso)," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto)," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(CURRENT_TIMESTAMP, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu " +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.inmueble_id = ?" +
            " AND inga.administrador_id = ? " +
            " AND inga.borrado is false " +
            " group by EXTRACT(YEAR FROM inga.fecha_factura)," +
            " inga.inmueble_id, " +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByInmuebleXAnios(int idInmueble, int administradorId);
    
    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id, " +
            " inga.fecha_factura) " +
            " sum(inga.total_gasto)," +
            " sum(inga.total_ingreso)," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto)," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(CURRENT_TIMESTAMP, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu" +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.inmueble_id = ?" +
            " AND year(inga.fecha_factura) = ?" +
            " AND inga.administrador_id = ? " +
            " AND inga.borrado is false " +
            " group by EXTRACT(YEAR FROM inga.fecha_factura), " +
            " inga.inmueble_id, " +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByInuebleAnioXMes(int idInmueble, int anio, int administradorId);

    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id, " +
            " inga.fecha_factura) " +
            " sum(inga.total_gasto)," +
            " sum(inga.total_ingreso)," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto)," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(CURRENT_TIMESTAMP, 'Month') AS \"Month\", " +
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
            " inga.inmueble_id, " +
            " inga.fecha_factura) " +
            " sum(inga.total_gasto)," +
            " sum(inga.total_ingreso)," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto)," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(CURRENT_TIMESTAMP, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu" +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.administrador_id = ?" +
            " AND year(inga.fecha_factura) = ? " +
            " AND inga.borrado is false " +
            " group by EXTRACT(MONTH FROM inga.fecha_factura), " +
            " inga.inmueble_id, " +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByAniosXMeses(int administradorId, int anio);

    @Query(value = "SELECT DISTINCT ON (inmu.alias, " +
            " inga.inmueble_id, " +
            " inga.fecha_factura) " +
            " sum(inga.total_gasto)," +
            " sum(inga.total_ingreso)," +
            " sum(inga.total_ingreso) - sum(inga.total_gasto)," +
            " inga.inmueble_id," +
            " inmu.alias," +
            " EXTRACT(YEAR FROM inga.fecha_factura) AS anio, " +
            " TO_CHAR(CURRENT_TIMESTAMP, 'Month') AS \"Month\", " +
            " (EXTRACT(MONTH FROM inga.fecha_factura)) " +
            " FROM ingreso_gasto as inga" +
            " join inmuebles as inmu" +
            " ON inga.inmueble_id = inmu.id_inmueble" +
            " WHERE inga.administrador_id = ?" +
            " AND year(inga.fecha_factura) = ?" +
            " AND month(inga.fecha_factura) = ? " +
            " AND inga.borrado is false " +
            " group by inga.inmueble_id" +
            " inmu.alias, " +
            " inga.fecha_factura", nativeQuery = true)
    List<String> findInformeByAniosMesesXInmuebles(int administradorId, int anio, int mes);

    List<IngresoGastoEntity> findByAdministradorIdAndFechaPagoIsNull(int administradorId);

    
}
