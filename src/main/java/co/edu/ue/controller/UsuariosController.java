package co.edu.ue.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuarioService usuariosService;

    // Expresiones regulares para validaciones
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String PHONE_REGEX = "^\\d{10}$";

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postUsuario(@RequestBody Usuarios usuario) {
        // Validar los datos
        String validationError = validarDatosUsuario(usuario);
        if (validationError != null) {
            return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
        }

        if (usuariosService.emailExists(usuario.getEmailUser())) {
            return new ResponseEntity<>("El correo electrónico ya está en uso", HttpStatus.CONFLICT);
        }

        if (usuario.getEstadoUsuario() == null) {
            usuario.setEstadoUsuario((byte) 1); // Asigna un valor por defecto si es null
        }

        Usuarios savedUsuario = usuariosService.guardar(usuario);
        return new ResponseEntity<>("Usuario creado con éxito: " + savedUsuario, HttpStatus.CREATED);
    }

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuariosList = usuariosService.obtenerTodos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-usuarios", String.valueOf(usuariosList.size()));
        return new ResponseEntity<>(usuariosList, headers, HttpStatus.OK);
    }

    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> putUsuario(@RequestBody Usuarios usuario) {
        // Validar los datos
        String validationError = validarDatosUsuario(usuario);
        if (validationError != null) {
            return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
        }

        if (usuario.getEstadoUsuario() == null) {
            usuario.setEstadoUsuario((byte) 1); // Asigna un valor por defecto si es null
        }

        Usuarios updatedUsuario = usuariosService.actualizar(usuario);
        return new ResponseEntity<>("Usuario actualizado con éxito: " + updatedUsuario, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> getIdUsuario(@PathVariable("id") int id) {
        Usuarios usuario = usuariosService.buscarPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> darDeBajaUsuario(@PathVariable int id) {
        try {
            usuariosService.darDeBaja(id);
            return ResponseEntity.ok("Usuario dado de baja con éxito");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Método privado para validar los datos del usuario
    private String validarDatosUsuario(Usuarios usuario) {
        // Validar nombre
        if (usuario.getNameUser() == null || usuario.getNameUser().isBlank()) {
            return "El nombre del usuario no puede estar vacío.";
        }

        // Validar correo electrónico
        if (!Pattern.matches(EMAIL_REGEX, usuario.getEmailUser())) {
            return "El correo electrónico no tiene un formato válido.";
        }

        // Validar número de teléfono
        if (!Pattern.matches(PHONE_REGEX, usuario.getNumeroUser())) {
            return "El número de teléfono debe contener exactamente 10 dígitos.";
        }

        // Todos los datos son válidos
        return null;
    }
}