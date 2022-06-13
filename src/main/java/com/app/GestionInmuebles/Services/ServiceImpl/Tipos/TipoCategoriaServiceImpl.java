package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaDTO;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaEntity;
import com.app.GestionInmuebles.DTO.Tipos.Categoria.TipoCategoriaResponse;
import com.app.GestionInmuebles.Repository.Tipos.TipoCategoriaRepository;
import com.app.GestionInmuebles.Services.Tipos.TipoCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para la generacion del codigo de los metodos implementados
 * @author Carlos Castillo
 */
@Service("TipoCategoriaServiceImpl")
public class TipoCategoriaServiceImpl implements TipoCategoriaService {

    //-------------------------------------------Variable Service de Tipo Categoria Repository----------------------------------------------

    @Autowired
    @Qualifier("TipoCategoriaRepository")
    private TipoCategoriaRepository tipoCategoriaRepository;

    //-------------------------------------------Metodos de la Clase Tipo Categoria Service Impl-------------------------------------------------------


    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TipoCategoriaResponse
     */
    @Override
    public List<TipoCategoriaResponse> listarCategoriaAdministradorId(int id) {
        List<TipoCategoriaResponse> list = new ArrayList<>();
        for (TipoCategoriaEntity i : tipoCategoriaRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                list.add(EntityToResponse(i));
            }
        }
        return list;
    }


    /**
     * Metodo para la obtencion de un listado de registros filtrato por unos tipos de inmuebles en especifico
     * @return Lista de TipoCategoriaResponse
     */
    @Override
    public List<TipoCategoriaResponse> listarCategoriaInmueble() {
        List<TipoCategoriaResponse> list = new ArrayList<>();
        for (TipoCategoriaEntity i : tipoCategoriaRepository.categoriaInmueble(1, 3)) {
            if (!i.isBorrado()) {
                list.add(EntityToResponse(i));
            }
        }
        return list;
    }


    /**
     * Metodo para la obtencion de un listado de registros filtrado por unos tipos de conceptos en especifico
     * @return Lista de TipoCategoriaResponse
     */
    @Override
    public List<TipoCategoriaResponse> ListarCategoriaConcepto() {
        List<TipoCategoriaResponse> list = new ArrayList<>();
        for (TipoCategoriaEntity i : tipoCategoriaRepository.categoriaConcepto(4, 8)) {
            if (!i.isBorrado()) {
                list.add(EntityToResponse(i));
            }
        }
        return list;
    }


    /**
     * Metodo para la obtencion de un listado de registros
     * @param id parametro necesario para la ejecucion del metodo
     * @return Lista de TipoCategoriaResponse
     */
    @Override
    public List<TipoCategoriaResponse> listarCategoriaIdCategoria(int id) {
        List<TipoCategoriaResponse> list = new ArrayList<>();
        for (TipoCategoriaEntity i : tipoCategoriaRepository.findByIdCategoria(id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    /**
     * Metodo usado para la creacion y modificacion
     * @param periodosDTO parametro necesario para la ejecucion del metodo
     * @return TipoCategoriaResponse
     */
    @Override
    public TipoCategoriaResponse createUpdateCategoria(TipoCategoriaDTO periodosDTO) {
        return EntityToResponse(tipoCategoriaRepository.save(DTOToEntity(periodosDTO)));
    }
}
