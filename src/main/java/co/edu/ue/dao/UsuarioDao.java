package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.jpa.IUsuariosJpa;

@Repository
public class UsuarioDao implements IUsuarioDao {

    @Autowired
    private IUsuariosJpa jpa;

    @Override
    public List<Usuarios> listaCompleta() {
        return jpa.findByEstadoUsuario((byte) 1); // Solo usuarios activos
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario) {
        return jpa.save(usuario);
    }

    @Override
    public Usuarios actualizarUsuario(Usuarios usuario) {
        return jpa.save(usuario); 
    }

    @Override
    public Usuarios busquedaPorId(int id) {
        return jpa.findById(id).orElse(null); 
    }

    @Override
    public Usuarios busquedaPorEmail(String email) {
        return jpa.findByEmailUser(email).orElse(null);
    }

    @Override
    public void darDeBajaUsuario(int id) {
        Usuarios usuario = jpa.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setEstadoUsuario((byte) 0); // Cambia el estado a inactivo
            jpa.save(usuario);
        }
    }

    @Override
    public boolean emailExists(String email) {
        return jpa.findByEmailUser(email).isPresent();
    }
}