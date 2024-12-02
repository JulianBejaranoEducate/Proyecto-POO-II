package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Usuarios;
import co.edu.ue.jpa.IUsuariosJpa;

@Repository
public class UsuarioDao implements IUsuarioDao {

    // Inyección por Interface de Jpa
    @Autowired
    private IUsuariosJpa jpa;

    @Override
    public List<Usuarios> listaCompleta() {
        return jpa.findAll(); // Recupera todos los usuarios de la base de datos
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario) {
        return jpa.save(usuario); // Guarda el usuario en la base de datos
    }

    @Override
    public Usuarios actualizarUsuario(Usuarios usuario) {
        return jpa.save(usuario); // Actualiza el usuario en la base de datos
    }

    @Override
    public Usuarios busquedaPorId(int id) {
        return jpa.findById(id).orElse(null); // Busca un usuario por su ID
    }

    @Override
    public Usuarios busquedaPorEmail(String email) {
        return jpa.findByEmailUser(email); // Busca un usuario por su email
    }

    @Override
    public void eliminarUsuario(int id) {
        jpa.deleteById(id); // Elimina un usuario por su ID
    }
}
