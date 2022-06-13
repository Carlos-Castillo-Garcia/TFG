package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("PersonasPagadorasRepository")
public interface PersonasPagadorasRepository extends JpaRepository<PersonasPagadorasEntity, Serializable> {
    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return PersonasPagadorasEntity
     */
    PersonasPagadorasEntity findByIdPersonasPagadora(int id);
}
