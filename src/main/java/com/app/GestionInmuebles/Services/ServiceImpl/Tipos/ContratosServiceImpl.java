package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Contrato.ContratosResponse;
import com.app.GestionInmuebles.Repository.Tipos.ContratosRepository;
import com.app.GestionInmuebles.Services.Tipos.ContratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ContratosServiceImpl")
public class ContratosServiceImpl implements ContratosService {
    @Autowired
    @Qualifier(value = "ContratosRepository")
    private ContratosRepository contratosRepository;

    @Override
    public List<ContratosResponse> listarTiposContratoadministradorId(int id) {
        List<ContratosResponse> tipos_contratoResponses = new ArrayList<>();
        for (ContratosEntity i : contratosRepository.getByadministradorId(id)) {
            if (!i.isBorrado()) {
                tipos_contratoResponses.add(EntityToResponse(i));
            }
        }
        return tipos_contratoResponses;
    }

    @Override
    public List<ContratosResponse> listarTiposContratoidContrato(int id) {
        List<ContratosResponse> tipos_contratoResponses = new ArrayList<>();
        for (ContratosEntity i : contratosRepository.getByidTipoContrato(id)) {
            tipos_contratoResponses.add(EntityToResponse(i));
        }
        return tipos_contratoResponses;
    }

    @Override
    public ContratosResponse createUpdateTiposContrato(ContratosDTO tiposContratoDTO) {
        return EntityToResponse(contratosRepository.save(DTOToEntity(tiposContratoDTO)));
    }
}
