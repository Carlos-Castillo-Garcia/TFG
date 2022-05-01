package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosDTO;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosEntity;
import com.app.GestionInmuebles.DTO.TipoPeriodos.TipoPeriodosResponse;
import com.app.GestionInmuebles.Repository.TipoPeriodoRepository;
import com.app.GestionInmuebles.Services.TipoPeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("TipoPeriodoServiceImpl")
public class TipoPeriodoServiceImpl implements TipoPeriodoService {

    @Autowired
    @Qualifier("TipoPeriodoRepository")
    private TipoPeriodoRepository tipoPeriodoRepository;

    @Override
    public List<TipoPeriodosResponse> listarTiposPeriodos() {
        List<TipoPeriodosResponse> list = new ArrayList<>();
        for (TipoPeriodosEntity i : tipoPeriodoRepository.findAll()) {
            if (i.getBorrado() == 0) {
                list.add(EntityToResponse(i));
            }
        }
        return list;
    }

    @Override
    public TipoPeriodosResponse createUpdateTipoPeriodo(TipoPeriodosDTO tipoPeriodosDTO) {
        return EntityToResponse(tipoPeriodoRepository.save(DTOToEntity(tipoPeriodosDTO)));
    }
}
