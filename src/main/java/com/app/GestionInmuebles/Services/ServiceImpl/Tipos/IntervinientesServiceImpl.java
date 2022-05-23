package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesDTO;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesEntity;
import com.app.GestionInmuebles.DTO.Tipos.Intervinientes.IntervinientesResponse;
import com.app.GestionInmuebles.Repository.Tipos.IntervinientesRepository;
import com.app.GestionInmuebles.Services.Tipos.IntervinientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("IntervinientesServiceImpl")
public class IntervinientesServiceImpl implements IntervinientesService {

    @Autowired
    @Qualifier(value = "IntervinientesRepository")
    private IntervinientesRepository tipoIntervinienteRepository;

    @Override
    public List<IntervinientesResponse> listTipoIntervinientesadministradorId(int id) {
        List<IntervinientesResponse> list = new ArrayList<>();
        for (IntervinientesEntity i : tipoIntervinienteRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                list.add(EntityToResponse(i));
            }
        }
        return list;
    }

    @Override
    public List<IntervinientesResponse> listTipoIntervinientesidIntervinientes(int id) {
        List<IntervinientesResponse> list = new ArrayList<>();
        for (IntervinientesEntity i : tipoIntervinienteRepository.getByidTipoInterviniente(id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    @Override
    public IntervinientesResponse createUpdateTipoIntervinientes(IntervinientesDTO intervinientesDTO) {
        return EntityToResponse(tipoIntervinienteRepository.save(DTOToEntity(intervinientesDTO)));
    }
}
