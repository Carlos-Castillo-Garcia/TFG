package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoDTO;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoEntity;
import com.app.GestionInmuebles.DTO.Tipos.Concepos.TipoConceptoResponse;
import com.app.GestionInmuebles.Repository.Tipos.TipoConceptoRepository;
import com.app.GestionInmuebles.Services.Tipos.ContratosService;
import com.app.GestionInmuebles.Services.Tipos.TipoConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TipoConceptoServiceImpl")
public class TipoConceptoServiceImpl implements TipoConceptoService {

    @Autowired
    @Qualifier("TipoConceptoRepository")
    private TipoConceptoRepository tipoConceptoRepository;

    @Override
    public List<TipoConceptoResponse> listarTiposConceptoAdministradorId(int id) {
        List<TipoConceptoResponse> tipoConceptoResponseList = new ArrayList<>();
        for (TipoConceptoEntity i : tipoConceptoRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                tipoConceptoResponseList.add(EntityToResponse(i));
            }
        }
        return tipoConceptoResponseList;
    }

    @Override
    public List<TipoConceptoResponse> listarTiposConceptoId(int id) {
        List<TipoConceptoResponse> tipoConceptoResponseList = new ArrayList<>();
        for (TipoConceptoEntity i : tipoConceptoRepository.getByidTipoConcepto(id)) {
            tipoConceptoResponseList.add(EntityToResponse(i));
        }
        return tipoConceptoResponseList;
    }

    @Override
    public TipoConceptoResponse createUpdateTiposConcepto(TipoConceptoDTO tipoConceptoDTO) {
        return EntityToResponse(tipoConceptoRepository.save(DTOToEntity(tipoConceptoDTO)));
    }
}
