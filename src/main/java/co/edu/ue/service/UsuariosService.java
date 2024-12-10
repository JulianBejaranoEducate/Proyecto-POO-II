package co.edu.ue.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.UsuarioDao;
import co.edu.ue.entity.Usuarios;

@Service
public class UsuariosService implements IUsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    // Expresiones regulares para validaciones
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    @Override
    public Usuarios guardar(Usuarios usuario) {
        validarDatosUsuario(usuario); // Validación antes de guardar
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
        validarDatosUsuario(usuario); // Validación antes de actualizar
        return usuarioDao.actualizarUsuario(usuario); 
    }

    // Método privado para validar los datos del usuario
    private void validarDatosUsuario(Usuarios usuario) throws IllegalArgumentException {
        // Validar nombre
        if (usuario.getNameUser() == null || usuario.getNameUser().isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacio.");
        }

        // Validar correo electrónico
        if (!Pattern.matches(EMAIL_REGEX, usuario.getEmailUser())) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato valido.");
        }

        // Validar número de teléfono
        if (!Pattern.matches(PHONE_REGEX, usuario.getNumeroUser())) {
            throw new IllegalArgumentException("El numero de teléfono debe contener exactamente 10 digitos.");
        }

        // Validar estado del usuario (opcional)
        if (usuario.getEstadoUsuario() == null) {
            throw new IllegalArgumentException("El estado del usuario no puede estar vacio.");
        }
    }
}
