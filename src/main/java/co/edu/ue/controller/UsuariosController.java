package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuarioService usuariosService;

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> postUsuario(@RequestBody Usuarios usuario) {
        Usuarios savedUsuario = usuariosService.guardar(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
    }

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Usuarios>> getAllUsuarios() {
        List<Usuarios> usuariosList = usuariosService.obtenerTodos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-usuarios", String.valueOf(usuariosList.size()));
        return new ResponseEntity<>(usuariosList, headers, HttpStatus.OK);
    }

    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> putUsuario(@RequestBody Usuarios usuario) {
        Usuarios updatedUsuario = usuariosService.actualizar(usuario);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.ACCEPTED);
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

    @GetMapping(value = "/email", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuarios> getByEmail(@RequestParam("email") String email) {
        Usuarios usuario = usuariosService.buscarPorEmail(email);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> darDeBajaUsuario(@PathVariable int id) {
        usuariosService.darDeBaja(id);
        return ResponseEntity.ok("Usuario dado de baja con éxito");
    }
}