package co.edu.ue.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IUsuarioDao;
import co.edu.ue.entity.Usuarios;
import jakarta.transaction.Transactional;
@Service
public class UsuariosService implements IUsuarioService {

    @Autowired
    private IUsuarioDao usuariosDao;

    @Override
    public List<Usuarios> obtenerTodos() {
        return usuariosDao.listaCompleta();
    }

    @Override
    @Transactional
    public Usuarios guardar(Usuarios usuario) {
        return usuariosDao.guardarUsuario(usuario);
    }

    @Override
    @Transactional
    public Usuarios actualizar(Usuarios usuario) {
        return usuariosDao.actualizarUsuario(usuario);
    }

    @Override
    public Usuarios buscarPorId(int id) {
        return usuariosDao.busquedaPorId(id);
    }

    @Override
    public Usuarios buscarPorEmail(String email) {
        return usuariosDao.busquedaPorEmail(email);
    }
    @Override
    @Transactional
    public void darDeBaja(int id) {
        Usuarios usuario = usuariosDao.busquedaPorId(id);
        if (usuario != null) {
            usuario.setEstadoUsuario(0); 
            usuariosDao.actualizarUsuario(usuario);
        }
}
}


