package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGastoDetalle.IngresoGastoDetalleResponse;
import com.app.GestionInmuebles.Repository.IngresoGastoDetalleRepository;
import com.app.GestionInmuebles.Services.IngresoGastoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("IngresoGastoDetalleServiceImpl")
public class IngresoGastoDetalleServiceImpl implements IngresoGastoDetalleService {

    @Autowired
    @Qualifier("IngresoGastoDetalleRepository")
    private IngresoGastoDetalleRepository ingresoGastoDetalleRepository;

    @Override
    public List<IngresoGastoDetalleResponse> listarIngresoGastoDetalleAdministradorId(int id) {
        List<IngresoGastoDetalleResponse> detalleResponseList = new ArrayList<>();
        for (IngresoGastoDetalleEntity i : ingresoGastoDetalleRepository.findByInGaId_IdInGaAndBorradoIsFalse(id)) {
            if (!i.isBorrado()) {
                detalleResponseList.add(EntityToResponse(i));
            }
        }
        return detalleResponseList;
    }

    @Override
    public List<IngresoGastoDetalleResponse> listarIngresoGastoDetalleId(int id) {
        List<IngresoGastoDetalleResponse> detalleResponseList = new ArrayList<>();
        for (IngresoGastoDetalleEntity i : ingresoGastoDetalleRepository.findByIdInGaDetalleAndBorradoIsFalse(id)) {
            detalleResponseList.add(EntityToResponse(i));
        }
        return detalleResponseList;
    }

    @Override
    public IngresoGastoDetalleResponse createUpdateIngresoGastoDetalle(IngresoGastoDetalleDTO i) {
        return EntityToResponse(ingresoGastoDetalleRepository.save(DTOToEntity(i)));
    }
}
