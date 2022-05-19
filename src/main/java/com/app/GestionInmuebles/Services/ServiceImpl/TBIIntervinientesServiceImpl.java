
package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import com.app.GestionInmuebles.Repository.TBIIntervinientesRepository;
import com.app.GestionInmuebles.Services.TBIIntervinientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TBIIntervinientesServiceImpl")
public class TBIIntervinientesServiceImpl implements TBIIntervinientesService {

    @Autowired
    @Qualifier("TBIIntervinientesRepository")
    private TBIIntervinientesRepository tbiIntervinientesRepository;

    @Override
    public List<TBIIntervinientesResponse> listarIntervinientesContratoId(int id) {
        List<TBIIntervinientesResponse> intervinientesEntities = new ArrayList<>();
        for (TBIIntervinientesEntity i : tbiIntervinientesRepository.getByContratosId(id)) {
            if (!i.isBorrado()) {
                intervinientesEntities.add(EntityToResponse(i));
            }
        }
        return intervinientesEntities;
    }

    @Override
    public List<TBIIntervinientesResponse> listarIntervinientesidIntervinientes(int id) {
        List<TBIIntervinientesResponse> intervinientes = new ArrayList<>();
        for (TBIIntervinientesEntity i : tbiIntervinientesRepository.getByidInterviniente(id)) {
            intervinientes.add(EntityToResponse(i));
        }
        return intervinientes;
    }

    @Override
    public TBIIntervinientesResponse createUpdateIntervinientes(TBIIntervinientesDTO intervinientesDTO) {
        return EntityToResponse(tbiIntervinientesRepository.save(DTOToEntity(intervinientesDTO)));
    }
}
