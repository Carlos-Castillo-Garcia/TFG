package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.PersonasPagadoras.PersonasPagadorasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository("PersonasPagadorasRepository")
public interface PersonasPagadorasRepository extends JpaRepository<PersonasPagadorasEntity, Serializable> {
    PersonasPagadorasEntity findByIdPersonasPagadora(int id);
}
