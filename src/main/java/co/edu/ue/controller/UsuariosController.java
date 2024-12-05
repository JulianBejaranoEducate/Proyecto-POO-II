package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.UsuariosService;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    // Crear un nuevo usuario
    @PostMapping(value = "usuario-sav", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> postUsuario(@RequestBody Usuarios usuario) {
        Usuarios savedUsuario = usuariosService.guardar(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    // Obtener todos los usuarios
    @GetMapping(value = "usuario-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuariosList = usuariosService.obtenerTodos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-usuarios", String.valueOf(usuariosList.size()));
        return new ResponseEntity<>(usuariosList, headers, HttpStatus.OK);
    }

    // Actualizar un usuario
    @PutMapping(value = "usuario-up")
    public ResponseEntity<Usuarios> putUsuario(@RequestBody Usuarios usuario) {
        Usuarios updatedUsuario = usuariosService.actualizar(usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.ACCEPTED);
    }

    // Buscar un usuario por ID
    @GetMapping(value = "usuario-id")
    public ResponseEntity<Usuarios> getIdUsuario(@RequestParam("id") int id) {
        Usuarios usuario = usuariosService.buscarPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Buscar un usuario por correo electrónico
    @GetMapping(value = "usuario-email")
    public ResponseEntity<Usuarios> getByEmail(@RequestParam("email") String email) {
        Usuarios usuario = usuariosService.buscarPorEmail(email);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Dar de baja un usuario
    @PutMapping(value = "usuario-baja")
    public ResponseEntity<String> bajaUsuario(@RequestParam("id") int id) {
        usuariosService.darDeBaja(id);
        return new ResponseEntity<>("Usuario dado de baja correctamente", HttpStatus.OK);
    }
}
