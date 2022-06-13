package com.app.GestionInmuebles.Controller;

import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasDTO;
import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasResponse;
import com.app.GestionInmuebles.Services.ServiceImpl.PersonasPagadorasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//Anotaciones del controlador para la creacion de apis y dar acceso a los datos desde angular
@RestController
@RequestMapping("/api/v1/personaspagadora")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PersonasPagadorasController {

    //-------------------------------------------Variable Service del controller de Inmuebles----------------------------------------------

    @Autowired
    @Qualifier("PersonasPagadorasServiceImpl")
    private PersonasPagadorasServiceImpl personasPagadorasService;

    //-------------------------------------------Metodos del controller de Inmuebles-------------------------------------------------------

    @PostMapping
    public PersonasPagadorasResponse createPersonasPagadoras(
             @RequestBody PersonasPagadorasDTO personasPagadorasDTO) {
        return personasPagadorasService.createUpdatePersonasPagadoras(personasPagadorasDTO);
    }

    @PutMapping
    public PersonasPagadorasResponse updateCliente(
             @RequestBody PersonasPagadorasDTO personaPagadoraDto) {
        return personasPagadorasService.createUpdatePersonasPagadoras(personaPagadoraDto);
    }

    @GetMapping("/{id}")
    public PersonasPagadorasResponse listClientesadministradorId(
             @PathVariable("id") int id) {
        return personasPagadorasService.listaridPersonasPagadoras(id);
    }

}
