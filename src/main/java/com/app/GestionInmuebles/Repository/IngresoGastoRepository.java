
package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("IngresoGastoRepository")
public interface IngresoGastoRepository extends JpaRepository<IngresoGastoEntity, Serializable> {
    /**
     * @param idAdministrador parametro necesario para la ejecucion del metodo
     * @return IngresoGastoEntity
     */
    List<IngresoGastoEntity> findByAdministradorIdOrderByFechaFacturaDesc(int idAdministrador);

    /**
     * @param idInGa parametro necesario para la ejecucion del metodo
     * @return IngresoGastoEntity
     */
    List<IngresoGastoEntity> findByIdInGa(int idInGa);

    /**
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @return IngresoGastoEntity
     */
    List<IngresoGastoEntity> findByAdministradorId(int administradorId);

    /**
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @param idCliente parametro necesario para la ejecucion del metodo
     * @return IngresoGastoEntity
     */
    List<IngresoGastoEntity> findByAdministradorIdAndFechaPagoIsNullAndClienteId_IdCliente(int administradorId, int idCliente);

    /**
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @param entidadId parametro necesario para la ejecucion del metodo
     * @return IngresoGastoEntity
     * Metodo para la obtencion de las facturas y los ingresos filtradas por administrador y entidad, agrupadas por id de factura y ordenadas por fecha de factura de forma descendente
     */
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

    /**
     * @param administradorId parametro necesario para la ejecucion del metodo
     * @return IngresoGastoEntity
     * Metodo para la obtencion de las fechas filtradas por el administrador y ordenadas por fecha factura de forma descendente
     */
    @Query("select i from IngresoGastoEntity i where i.administradorId = ?1 order by i.fechaFactura DESC")
    List<IngresoGastoEntity> obtencionFecha(int administradorId);

    /**
     * @param idEntidad parametro necesario para la ejecucion del metodo
     * @return String
     * Metodo para la obtencion de informes de inmuebles filtrados por la entidad
     */
    @Query(value = "SELECT SUM(inga2.total_gasto) AS total_gasto, " +
            "SUM(inga2.total_ingreso) AS total_ingreso, " +
            "SUM(inga2.total_ingreso) - SUM(inga2.total_gasto) AS total_balance, " +
            "inmu.id_inmueble, " +
            "inmu.alias  " +
            "FROM (SELECT inga.total_gasto, " +
            "inga.total_ingreso, " +
            "inga.inmueble_id as inmueble, " +
            "EXTRACT(YEAR  " +
            "FROM inga.fecha_factura)  AS anio, " +
            "EXTRACT(MONTH  " +
            "FROM inga.fecha_factura) AS mes  " +
            "FROM ingreso_gasto AS inga) AS inga2  " +
            "JOIN inmuebles AS inmu  " +
            "ON inga2.inmueble = inmu.id_inmueble " +
            "GROUP BY inmu.alias, " +
            "inmu.id_inmueble", nativeQuery = true)
    List<String> findInformeXInmueble(int idEntidad);

    /**
     * @param idInmueble parametro necesario para la ejecucion del metodo
     * @return String
     * Metodo para la obtencion de informes por años filtrados por el inmueble
     */
    @Query(value = "SELECT SUM(inga2.total_gasto)AS total_gasto,  " +
            " SUM(inga2.total_ingreso) AS total_ingreso,  " +
            " SUM(inga2.total_ingreso) - SUM(inga2.total_gasto) AS total_balance,  " +
            " inmu.id_inmueble,  " +
            " inmu.alias,  " +
            " inga2.anio   " +
            "FROM ( SELECT inga.total_gasto,  " +
            "   inga.total_ingreso,  " +
            "   inga.inmueble_id as inmueble,  " +
            "   EXTRACT(YEAR FROM inga.fecha_factura)  AS anio,  " +
            "   EXTRACT(MONTH FROM inga.fecha_factura) AS mes   " +
            "  FROM ingreso_gasto AS inga) AS inga2   " +
            "  JOIN inmuebles as inmu  " +
            "  ON inga2.inmueble = inmu.id_inmueble  " +
            "WHERE inmu.id_inmueble = 1  " +
            "GROUP BY inmu.alias,  " +
            " inmu.id_inmueble,  " +
            " inga2.anio", nativeQuery = true)
    List<String> findInformeByInmuebleXAnios(int idInmueble);

    /**
     * @param idInmueble parametro necesario para la ejecucion del metodo
     * @param anio parametro necesario para la ejecucion del metodo
     * @return String
     * Metodo para la obtencion de informes por meses filtrados por el inmueble y el año
     */
    @Query(value = "SELECT SUM(inga2.total_gasto) AS total_gasto,   " +
            "  SUM(inga2.total_ingreso) AS total_ingreso,   " +
            "  SUM(inga2.total_ingreso) - SUM(inga2.total_gasto) AS total_balance,   " +
            "  inmu.id_inmueble,   " +
            "  inmu.alias,   " +
            "  inga2.anio,   " +
            "  inga2.mes    " +
            "FROM (SELECT inga.total_gasto,   " +
            "      inga.total_ingreso,   " +
            "      inga.inmueble_id as inmueble,   " +
            "      EXTRACT(YEAR FROM inga.fecha_factura)  AS anio,   " +
            "      EXTRACT(MONTH FROM inga.fecha_factura) AS mes    " +
            "    FROM ingreso_gasto AS inga) AS inga2    " +
            "    JOIN inmuebles as inmu   " +
            "    ON inga2.inmueble = inmu.id_inmueble   " +
            "WHERE inmu.id_inmueble = ?1   " +
            "AND inga2.anio = ?2 " +
            "GROUP BY inmu.alias,   " +
            "  inmu.id_inmueble,   " +
            "  inga2.anio,   " +
            "  inga2.mes", nativeQuery = true)
    List<String> findInformeByInuebleAnioXMes(int idInmueble, int anio);
}
