package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosDTO;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosEntity;
import com.app.GestionInmuebles.DTO.TBIContrato.TBIContratosResponse;
import com.app.GestionInmuebles.Repository.TBIContratosRepository;
import com.app.GestionInmuebles.Services.TBIContratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TBIContratosServiceImpl")
public class TBIContratosServiceImpl implements TBIContratosService {

    @Autowired
    @Qualifier("TBIContratosRepository")
    private TBIContratosRepository tbiContratosRespository;

    @Override
    public List<TBIContratosResponse> listarContratos() {
        List<TBIContratosResponse> responses = new ArrayList<>();
        for (TBIContratosEntity i : tbiContratosRespository.findAll()) {
            responses.add(EntityToResponse(i));
        }
        return responses;
    }

    @Override
    public TBIContratosResponse CrearContratos(TBIContratosDTO tbiContratosDTO) {
        return EntityToResponse(tbiContratosRespository.save(DTOToEntity(tbiContratosDTO)));
    }
}
