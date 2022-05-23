package com.app.GestionInmuebles.Services.ServiceImpl.Tipos;

import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosDTO;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosEntity;
import com.app.GestionInmuebles.DTO.Tipos.Pagos.PagosResponse;
import com.app.GestionInmuebles.Repository.Tipos.PagosRepository;
import com.app.GestionInmuebles.Services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PagosServiceImpl")
public class PagosServiceImpl implements PagosService {

    @Autowired
    private PagosRepository pagosRepository;

    @Override
    public List<PagosResponse> listarPagosIdAdministrador(int id) {
        List<PagosResponse> pagosResponseList = new ArrayList<>();
        for (PagosEntity i : pagosRepository.findByAdministradorIdOrAdministradorId(0, id)) {
            if (!i.isBorrado()) {
                pagosResponseList.add(EntityToResponse(i));
            }
        }
        return pagosResponseList;
    }

    @Override
    public List<PagosResponse> listarPagosIdPagos(int id) {
        List<PagosResponse> pagosResponseList = new ArrayList<>();
        for (PagosEntity i : pagosRepository.findByIdTipoPago(id)) {
            pagosResponseList.add(EntityToResponse(i));
        }
        return pagosResponseList;
    }

    @Override
    public PagosResponse createUpdatePagos(PagosDTO dto) {
        return EntityToResponse(pagosRepository.save(DTOToEntity(dto)));
    }
}
