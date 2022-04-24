package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesDTO;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesEntity;
import com.app.GestionInmuebles.DTO.TBIIntervinientes.TBIIntervinientesResponse;
import com.app.GestionInmuebles.Repository.TBIIntervinientesRepository;
import com.app.GestionInmuebles.Services.TBIIntervinientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class TBIIntervinientesServiceImpl implements TBIIntervinientesService {

    @Autowired
    @Qualifier("TBIIntervinientesRepository")
    private TBIIntervinientesRepository tbiIntervinientesRepository;

    @Override
    public List<TBIIntervinientesResponse> listarIntervinientes() {
        List<TBIIntervinientesResponse> intervinientes = new ArrayList<>();
        for (TBIIntervinientesEntity i : tbiIntervinientesRepository.findAll()) {
            intervinientes.add(EntityToResponse(i));
        }
        return intervinientes;
    }

    @Override
    public TBIIntervinientesResponse CrearIntervinientes(TBIIntervinientesDTO intervinientesDTO) {
        return EntityToResponse(tbiIntervinientesRepository.save(DTOToEntity(intervinientesDTO)));
    }
}
