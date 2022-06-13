package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Clase para la generacion de metodos de peticiones a la base de datos
 * @author Carlos Castillo
  */
@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Serializable> {
    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return UsuariosEntity
     */
    List<UsuariosEntity> getByadministradorId(int id);

    /**
     * @param id parametro necesario para la ejecucion del metodo
     * @return UsuariosEntity
     */
    List<UsuariosEntity> getByidUsuario(int id);

    /**
     * @param email parametro necesario para la ejecucion del metodo
     * @param password parametro necesario para la ejecucion del metodo
     * @return UsuariosEntity
     * Metodo para la comprobacion del email y la contraseña para loguearse con la base de datos
     */
    UsuariosEntity getByEmailAndPassword(String email, String password);
}
