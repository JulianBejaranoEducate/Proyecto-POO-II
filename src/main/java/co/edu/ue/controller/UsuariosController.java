package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import co.edu.ue.entity.Usuarios;
import co.edu.ue.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuarioService usuariosService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuarios>> obtenerTodos() {
        return ResponseEntity.ok(usuariosService.obtenerTodos());
    }

    // Guardar un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuarios> guardar(@RequestBody Usuarios usuario) {
        return ResponseEntity.ok(usuariosService.guardar(usuario));
    }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizar(@PathVariable int id, @RequestBody Usuarios usuario) {
        usuario.setIdUser(id); // Asegurarse de que el ID coincida
        return ResponseEntity.ok(usuariosService.actualizar(usuario));
    }

    // Buscar un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> buscarPorId(@PathVariable int id) {
        Usuarios usuario = usuariosService.buscarPorId(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar un usuario por email
    @GetMapping("/buscarPorEmail")
    public ResponseEntity<Usuarios> buscarPorEmail(@RequestParam String email) {
        Usuarios usuario = usuariosService.buscarPorEmail(email);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.notFound().build();
    }

    // Dar de baja a un usuario
    @PutMapping("/darDeBaja/{id}")
    public ResponseEntity<?> darDeBaja(@PathVariable int id) {
        try {
            usuariosService.darDeBaja(id);
            return ResponseEntity.ok("Usuario dado de baja correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al dar de baja al usuario.");
        }
    }
}
