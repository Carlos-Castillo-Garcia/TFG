package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoDTO;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoEntity;
import com.app.GestionInmuebles.DTO.IgresoGastoGeneral.IngresoGasto.IngresoGastoResponse;
import com.app.GestionInmuebles.Repository.IngresoGastoRepository;
import com.app.GestionInmuebles.Services.IngresoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("IngresoGastoServiceImpl")
public class IngresoGastoServiceImpl implements IngresoGastoService {

    @Autowired
    @Qualifier("IngresoGastoRepository")
    private IngresoGastoRepository ingresoGastoRepository;

    @Override
    public List<IngresoGastoResponse> listarIngresoGasto(int id) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByAdministradorId(id)) {
            if (!i.isBorrado()) {
                ingresoGastoResponseList.add(EntityToResponse(i));
            }
        }
        return ingresoGastoResponseList;
    }

    @Override
    public List<IngresoGastoResponse> listarIngresoGastoId(int id) {
        List<IngresoGastoResponse> ingresoGastoResponseList = new ArrayList<>();
        for (IngresoGastoEntity i : ingresoGastoRepository.findByIdInGa(id)) {
            ingresoGastoResponseList.add(EntityToResponse(i));
        }
        return ingresoGastoResponseList;
    }

    @Override
    public List<String> listarfechas(int id) {
        List<String> listaFechas = new ArrayList<>();
        List<IngresoGastoEntity> ingresoGastoEntityList = ingresoGastoRepository.obtencionFecha(id);
        for (int i = 0; i < ingresoGastoEntityList.size(); i++) {
            if (listaFechas.size() == 0){
                listaFechas.add(ingresoGastoEntityList.get(i).getFechaFactura().toString().substring(0,4));
            }
            for (int j = listaFechas.size(); j != 0; j--) {
                if (!ingresoGastoEntityList.get(i).getFechaFactura().toString().substring(0,4).equals(listaFechas.get(listaFechas.size()-1))){
                    listaFechas.add(ingresoGastoEntityList.get(i).getFechaFactura().toString().substring(0,4));
                }
            }
        }
        return listaFechas;
    }

    @Override
    public IngresoGastoResponse createUpdateIgresoGasto(IngresoGastoDTO i) {
        return EntityToResponse(ingresoGastoRepository.save(DTOToEntity(i)));
    }
}
