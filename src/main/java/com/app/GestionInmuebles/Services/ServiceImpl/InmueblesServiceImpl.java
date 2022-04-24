package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleDTO;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleResponse;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Repository.InmueblesRepository;
import com.app.GestionInmuebles.Services.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("InmueblesServiceImpl")
public class InmueblesServiceImpl implements InmuebleService {

    @Autowired
    @Qualifier("InmueblesRepository")
    private InmueblesRepository inmueblesRepository;

    @Override
    public InmuebleEntity DTOToEntity(InmuebleDTO inmueble) {
        InmuebleEntity casteo = new InmuebleEntity();
        casteo.setId_inmueble(inmueble.getId_inmueble());
        casteo.setRef_catastral(inmueble.getRef_catastral());
        casteo.setAlias(inmueble.getAlias());
        casteo.setLocalidad(inmueble.getLocalidad());
        casteo.setDireccion(inmueble.getDireccion());
        casteo.setCodigo_postal(inmueble.getCp());
        return casteo;
    }

    @Override
    public InmuebleResponse EntityToResponse(InmuebleEntity inmueble) {
        InmuebleResponse casteo = new InmuebleResponse();
        casteo.setId_inmueble(inmueble.getId_inmueble());
        casteo.setRef_catastral(inmueble.getRef_catastral());
        casteo.setAlias(inmueble.getAlias());
        casteo.setLocalidad(inmueble.getLocalidad());
        casteo.setDireccion(inmueble.getDireccion());
        casteo.setCp(inmueble.getCodigo_postal());
        return casteo;
    }

    @Override
    public List<InmuebleResponse> listar_Inmuebles() {
        List<InmuebleResponse> inmuebleResponseList = new ArrayList<>();
        for (InmuebleEntity i: inmueblesRepository.findAll()) {
            inmuebleResponseList.add(this.EntityToResponse(i));
        }
        return inmuebleResponseList;
    }

    @Override
    public void CrearInmuebles(String ref_catastral, String alias,
                               String localidad, String direccion, int codigo_postal) {
        InmuebleEntity inmueble = new InmuebleEntity();
        inmueble.setRef_catastral(ref_catastral);
        inmueble.setAlias(alias);
        inmueble.setLocalidad(localidad);
        inmueble.setDireccion(direccion);
        inmueble.setCodigo_postal(codigo_postal);
        inmueblesRepository.save(inmueble);
    }
}
