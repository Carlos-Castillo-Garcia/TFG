package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoDTO;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoEntity;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
import com.app.GestionInmuebles.Repository.TiposContratoRepository;
import com.app.GestionInmuebles.Services.TiposContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service("TiposContratoServiceImpl")
public class TiposContratoServiceImpl implements TiposContratoService {

    @Autowired
    @Qualifier("TiposContratoRepository")
    private TiposContratoRepository tiposContratoRepository;

    @Override
    public List<TiposContratoResponse> listarTipos() {
        List<TiposContratoResponse> tipos_contratoResponses = new ArrayList<>();
        for (TiposContratoEntity i: tiposContratoRepository.findAll()) {
            tipos_contratoResponses.add(EntityToResponse(i));
        }
        return tipos_contratoResponses;
    }

    @Override
    public TiposContratoResponse crearTipos(TiposContratoDTO tiposContratoDTO) {
        return EntityToResponse(tiposContratoRepository.save(DTOToEntity(tiposContratoDTO)));
    }
}
