package com.app.GestionInmuebles.Services;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.text.ParseException;
import java.util.List;

/**
 * Interfaz de Ingreso Gasto
 * @author Carlos Castillo
 */
public interface IngresoGastoService {

    /**
     * Configuracion del mapper Entity to Response
     */
    PropertyMap<IngresoGastoEntity, IngresoGastoResponse> ENTITYTORESPONSE = new PropertyMap<IngresoGastoEntity, IngresoGastoResponse>() {
        protected void configure() {
            map().setInmuebleId(source.getInmuebleId().getIdInmueble());
            map().setClienteId(source.getClienteId().getIdCliente());
            map().setTipoCategoriaId(source.getTipoConceptoId().getCategoriaId().getIdCategoria());
            map().setTipoCategoria(source.getTipoConceptoId().getCategoriaId().getCategoria());
            map().setTipoConceptoId(source.getTipoConceptoId().getIdTipoConcepto());
            map().setTipoConcepto(source.getTipoConceptoId().getTipoConcepto());
            map().setTipoPagoId(source.getTipoPagoId().getIdTipoPago());
            map().setUsuarioId(source.getUsuarioId());
            map().setAdministradorId(source.getAdministradorId());
        }
    };

    /**
     * Mapper de DTO a Entity
     * @param i parametro necesario para la ejecucion del metodo
     * @return IngresoGastoEntity
     */
    default IngresoGastoEntity DTOToEntity(IngresoGastoDTO i){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(i, IngresoGastoEntity.class);
    }

    /**
     * Mapper de Entity a Response
     * @param i parametro necesario para la ejecucion del metodo
     * @return IngresoGastoResponse
     */
    default IngresoGastoResponse EntityToResponse(IngresoGastoEntity i) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(ENTITYTORESPONSE);
        IngresoGastoResponse ingresoGastoResponse = modelMapper.map(i, IngresoGastoResponse.class);
        ingresoGastoResponse.setNombreApellidosCliente(i.getClienteId().getApellidos() + ", " + i.getClienteId().getNombre());
        ingresoGastoResponse.setAliasInmueble(i.getInmuebleId().getAlias());
        return ingresoGastoResponse;
    }

    List<IngresoGastoResponse> listarIngresoGasto(int id);

    List<IngresoGastoResponse> listarIngresoGastoId(int id);

    List<IngresoGastoResponse> listarIngresoGastoEntidad(int idAdministrador, int entidad);

    List<String> listarfechas(int id);

    IngresoGastoResponse createUpdateIgresoGasto(IngresoGastoDTO i) throws ParseException;

    List<IngresoGastoResponse> avisosFacturasAdministradorId(int administradorId, int clienteId);
}
