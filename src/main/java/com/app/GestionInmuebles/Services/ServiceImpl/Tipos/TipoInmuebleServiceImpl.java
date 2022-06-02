package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleDTO;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleEntity;
import com.app.GestionInmuebles.DTO.Tipos.Inmuebles.TipoInmuebleResponse;
import com.app.GestionInmuebles.Repository.Tipos.TipoInmuebleRepository;
import com.app.GestionInmuebles.Services.Tipos.TipoInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TipoInmuebleServiceImpl")
public class TipoInmuebleServiceImpl implements TipoInmuebleService {

    @Autowired
    @Qualifier("TipoInmuebleRepository")
    private TipoInmuebleRepository tipoInmuebleRepository;

    @Override
    public List<TipoInmuebleResponse> listTipoInmuebleadministradorId(int id) {
        List<TipoInmuebleResponse> list = new ArrayList<>();
        for (TipoInmuebleEntity i : tipoInmuebleRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    @Override
    public List<TipoInmuebleResponse> listTipoInmuebleidInmuebles(int id) {
        List<TipoInmuebleResponse> list = new ArrayList<>();
        for (TipoInmuebleEntity i : tipoInmuebleRepository.getByidTipoInmueble(id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    @Override
    public List<TipoInmuebleResponse> listTipoInmuebleidInmueblesByCategoria(int idCategoria, int idAdministrador) {
        List<TipoInmuebleResponse> list = new ArrayList<>();
        for (TipoInmuebleEntity i : tipoInmuebleRepository.findByAdministradorIdAndCategoriaId_IdCategoriaOrAdministradorId(0, idCategoria, idAdministrador)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    @Override
    public TipoInmuebleResponse createUpdateTipoInmueble(TipoInmuebleDTO tipoInmuebleDTO) {
        return EntityToResponse(tipoInmuebleRepository.save(DTOToEntity(tipoInmuebleDTO)));
    }
}
