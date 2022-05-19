package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Periodos.PeriodosResponse;
import com.app.GestionInmuebles.Repository.Tipos.PeriodosRepository;
import com.app.GestionInmuebles.Services.Tipos.PeriodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PeriodosServiceImpl")
public class PeriodosServiceImpl implements PeriodosService {

    @Autowired
    @Qualifier("PeriodosRepository")
    private PeriodosRepository tipoPeriodoRepository;

    @Override
    public List<PeriodosResponse> listarPeriodosadministradorId(int id) {
        List<PeriodosResponse> list = new ArrayList<>();
        for (PeriodosEntity i : tipoPeriodoRepository.getByadministradorId(id)) {
            if (!i.isBorrado()) {
                list.add(EntityToResponse(i));
            }
        }
        return list;
    }

    @Override
    public List<PeriodosResponse> listarPeriodosidPeriodos(int id) {
        List<PeriodosResponse> list = new ArrayList<>();
        for (PeriodosEntity i : tipoPeriodoRepository.getByidTipoPeriodo(id)) {
            list.add(EntityToResponse(i));
        }
        return list;
    }

    @Override
    public PeriodosResponse createUpdatePeriodos(PeriodosDTO periodosDTO) {
        return EntityToResponse(tipoPeriodoRepository.save(DTOToEntity(periodosDTO)));
    }
}
