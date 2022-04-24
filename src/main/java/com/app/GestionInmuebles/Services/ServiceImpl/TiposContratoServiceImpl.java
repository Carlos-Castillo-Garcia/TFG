package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoDTO;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoEntity;
import com.app.GestionInmuebles.DTO.TiposContrato.TiposContratoResponse;
import com.app.GestionInmuebles.Repository.TiposContratoRepository;
import com.app.GestionInmuebles.Services.TiposContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TiposContratoServiceImpl")
public class TiposContratoServiceImpl implements TiposContratoService {

    @Autowired
    @Qualifier("TiposContratoRepository")
    private TiposContratoRepository tiposContratoRepository;

    @Override
    public List<TiposContratoResponse> ListarTipos() {
        List<TiposContratoResponse> tipos_contratoResponses = new ArrayList<>();
        for (TiposContratoEntity i: tiposContratoRepository.findAll()) {
            tipos_contratoResponses.add(this.EntityToResponse(i));
        }
        return tipos_contratoResponses;
    }

    @Override
    public void CrearTipos(String tipo_contrato, String tipo_interviniete) {
        TiposContratoEntity nuevo = new TiposContratoEntity();
        nuevo.setTipos_contrato(tipo_contrato);
        nuevo.setTipos_interviniente(tipo_interviniete);
        tiposContratoRepository.save(nuevo);
    }
}
