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
        return jpa.findAll(); 
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
    public Usuarios busquedaPorEmail(String emailUser) {
        return jpa.findByEmailUser(emailUser); 
    }

    @Override
    public void eliminarUsuario(int id) {
        jpa.deleteById(id); 
    }
}
