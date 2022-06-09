package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InmueblesXClientesRespone;
import com.app.GestionInmuebles.DTO.ResponseUnitarios.InversionResponse;
import com.app.GestionInmuebles.Repository.InmueblesRepository;
import com.app.GestionInmuebles.Services.CastersUnitarios;
import com.app.GestionInmuebles.Services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("InmueblesServiceImpl")
public class InmueblesServiceImpl implements InmuebleService, CastersUnitarios {

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
    public List<InmuebleResponse> pruebaInmuebles(int idAdministrador, int entidad){
        List<InmuebleResponse> inmuebleResponseList = new ArrayList<>();
        for (InmuebleEntity i: inmueblesRepository.getByEntidadOrderByAlias(idAdministrador, entidad)) {
            inmuebleResponseList.add(EntityToResponse(i));
        }
        return inmuebleResponseList;
    }

    @Override
    public InmuebleResponse createUpdateInmuebles(InmuebleDTO inmuebleDTO) {
        return EntityToResponse(inmueblesRepository.save(DTOToEntity(inmuebleDTO)));
    }

    @Override
    public List<InmueblesXClientesRespone> propiedad(int idCliente){
        List<InmueblesXClientesRespone> inmueblesXClientesRespones = new ArrayList<>();
        for (String i: inmueblesRepository.propiedad(idCliente, 1)) {
            inmueblesXClientesRespones.add(bbddToResponseInmueblesXClientes(i));
        }
        return inmueblesXClientesRespones;
    }

    @Override
    public List<InversionResponse> inversion(int idInmueble){
        List<InversionResponse> inmueblesXClientesRespones = new ArrayList<>();
        for (String i: inmueblesRepository.inversiones(idInmueble)) {
            inmueblesXClientesRespones.add(bbddToResponseInversiones(i));
        }
        return inmueblesXClientesRespones;
    }
}
