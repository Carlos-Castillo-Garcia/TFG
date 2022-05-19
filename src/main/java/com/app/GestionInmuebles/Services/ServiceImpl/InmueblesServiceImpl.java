package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.Repository.InmueblesRepository;
import com.app.GestionInmuebles.Services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("InmueblesServiceImpl")
public class InmueblesServiceImpl implements InmuebleService {

    @Autowired
    @Qualifier("InmueblesRepository")
    private InmueblesRepository inmueblesRepository;

    @Override
    public List<InmuebleResponse> listarInmueblesIdAdministrador(int id) {
        List<InmuebleResponse> inmuebleResponseList = new ArrayList<>();
        for (InmuebleEntity i: inmueblesRepository.getByadministradorId(id)) {
            if (!i.isBorrado()) {
                inmuebleResponseList.add(EntityToResponse(i));
            }
        }
        return inmuebleResponseList;
    }

    @Override
    public List<InmuebleResponse> listarInmueblesIdInmueble(int id) {
        List<InmuebleResponse> inmuebleResponseList = new ArrayList<>();
        for (InmuebleEntity i: inmueblesRepository.getByidInmueble(id)) {
                inmuebleResponseList.add(EntityToResponse(i));
        }
        return inmuebleResponseList;
    }

    @Override
    public InmuebleResponse createUpdateInmuebles(InmuebleDTO inmuebleDTO) {
        return EntityToResponse(inmueblesRepository.save(DTOToEntity(inmuebleDTO)));
    }
}
