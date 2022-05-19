package com.app.GestionInmuebles.Repository;

import com.app.GestionInmuebles.DTO.Inmuebles.InmuebleEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosEntity;
import com.app.GestionInmuebles.DTO.Usuarios.UsuariosResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("UsuarioRepository")
public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Serializable> {
    List<UsuariosEntity> getByadministradorId(int id);
    List<UsuariosEntity> getByidUsuario(int id);
    UsuariosEntity getByEmailAndPassword(String email, String password);
}
