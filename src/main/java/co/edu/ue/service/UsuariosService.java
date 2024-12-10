package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.UsuarioDao;
import co.edu.ue.entity.Usuarios;

@Service
public class UsuariosService implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuarios guardar(Usuarios usuario) {
        return usuarioDao.guardarUsuario(usuario);
    }

    @Override
    public List<Usuarios> obtenerTodos() {
        return usuarioDao.listaCompleta();
    }

    @Override
    public Usuarios buscarPorId(int id) {
        return usuarioDao.busquedaPorId(id);
    }

    @Override
    public Usuarios buscarPorEmail(String email) {
        return usuarioDao.busquedaPorEmail(email);
    }

    @Override
    public void darDeBaja(int id) {
        usuarioDao.darDeBajaUsuario(id);
    }

    @Override
    public boolean emailExists(String email) {
        return usuarioDao.emailExists(email);
    }

    @Override
    public Usuarios actualizar(Usuarios usuario) {
        return usuarioDao.actualizarUsuario(usuario); 
    }
}