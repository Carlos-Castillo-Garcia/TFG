package com.app.GestionInmuebles.Services.ServiceImpl;

import com.app.GestionInmuebles.DTO.Clientes.ClientesDTO;
import com.app.GestionInmuebles.DTO.Clientes.ClientesResponse;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasDTO;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasResponse;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosDTO;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import com.app.GestionInmuebles.Repository.PersonasPagadorasRepository;
import com.app.GestionInmuebles.Services.PersonasPagadorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("PersonasPagadorasServiceImpl")
public class PersonasPagadorasServiceImpl implements PersonasPagadorasService {

    @Autowired
    private PersonasPagadorasRepository administradorRepository;

    @Autowired
    @Qualifier("ClienteServiceImpl")
    private ClienteServiceImpl clienteService;

    @Autowired
    @Qualifier("UsuarioServiceImpl")
    private UsuarioServiceImpl usuarioService;

    @Override
    public PersonasPagadorasResponse listaridPersonasPagadoras(int id) {
        return this.EntityToResponse(administradorRepository.findByIdPersonasPagadora(id));
    }

    @Override
    public PersonasPagadorasResponse createUpdatePersonasPagadoras(PersonasPagadorasDTO i) {
        UsuariosDTO usuariosDTO = new UsuariosDTO();
        ClientesDTO clientesDTO = new ClientesDTO();
        PersonasPagadorasResponse personasPagadorasResponse = EntityToResponse(administradorRepository.save(this.DTOToEntity(i)));

        usuariosDTO.setIdUsuario(0);
        usuariosDTO.setNombre(personasPagadorasResponse.getNombre());
        usuariosDTO.setEmail(personasPagadorasResponse.getEmail());
        usuariosDTO.setPassword("Passw0rd!");
        usuariosDTO.setBorrado(false);
        usuariosDTO.setRolId(1);
        usuariosDTO.setCreateTime(personasPagadorasResponse.getCreateTime());
        usuariosDTO.setUpdateTime(personasPagadorasResponse.getUpdateTime());
        usuariosDTO.setAdministradorId(personasPagadorasResponse.getIdPersonasPagadora());
        UsuariosResponse userResponse = usuarioService.createUpdateUsuarios(usuariosDTO);

        clientesDTO.setNombre(personasPagadorasResponse.getNombre());
        clientesDTO.setApellidos(personasPagadorasResponse.getApellidos());
        clientesDTO.setEmail(personasPagadorasResponse.getEmail());
        clientesDTO.setNie(personasPagadorasResponse.getNie());
        clientesDTO.setFechaNacimiento(personasPagadorasResponse.getFechaNacimiento());
        clientesDTO.setDireccion(personasPagadorasResponse.getDireccion());
        clientesDTO.setLocalidad(personasPagadorasResponse.getLocalidad());
        clientesDTO.setCodigoPostal(personasPagadorasResponse.getCodigoPostal());
        clientesDTO.setTlf(personasPagadorasResponse.getTlf());
        clientesDTO.setTlfMovil(personasPagadorasResponse.getTlfMovil());
        clientesDTO.setBorrado(false);
        clientesDTO.setCreateTime(personasPagadorasResponse.getCreateTime());
        clientesDTO.setUpdateTime(personasPagadorasResponse.getUpdateTime());
        clientesDTO.setUsuarioId(userResponse.getIdUsuario());
        clientesDTO.setAdministradorId(personasPagadorasResponse.getIdPersonasPagadora());
        ClientesResponse clientesResponse = clienteService.createUpdateClientes(clientesDTO);

        usuariosDTO.setIdUsuario(userResponse.getIdUsuario());
        usuariosDTO.setEntidadId(clientesResponse.getIdCliente());
        usuarioService.createUpdateUsuarios(usuariosDTO);

        return personasPagadorasResponse;
    }
}
