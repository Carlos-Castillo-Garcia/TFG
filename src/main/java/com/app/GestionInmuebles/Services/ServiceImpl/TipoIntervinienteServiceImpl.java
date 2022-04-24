package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteDTO;
import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteEntity;
import com.app.GestionInmuebles.DTO.TipoInterviniente.TipoIntervinienteResponse;
import com.app.GestionInmuebles.Repository.TipoIntervinienteRepository;
import com.app.GestionInmuebles.Services.TipoIntervinienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TipoIntervinienteServiceImpl")
public class TipoIntervinienteServiceImpl implements TipoIntervinienteService {

    @Autowired
    @Qualifier("TipoIntervinienteRepository")
    private TipoIntervinienteRepository tipoIntervinienteRepository;

    @Override
    public List<TipoIntervinienteResponse> listTipoInterviniente() {
        List<TipoIntervinienteResponse> list = new ArrayList<>();
        for (TipoIntervinienteEntity i : tipoIntervinienteRepository.findAll()) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    @Override
    public TipoIntervinienteResponse crearTipoInterviniente(TipoIntervinienteDTO tipoIntervinienteDTO) {
        return EntityToResponse(tipoIntervinienteRepository.save(DTOToEntity(tipoIntervinienteDTO)));
    }
}
