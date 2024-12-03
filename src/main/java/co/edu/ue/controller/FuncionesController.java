package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import co.edu.ue.entity.Funciones;
import co.edu.ue.service.IFuncionesService;

@RestController
@RequestMapping("/funciones")
public class FuncionesController {

    @Autowired
    private IFuncionesService funcionesService;

    @GetMapping
    public ResponseEntity<List<Funciones>> obtenerTodas() {
        return ResponseEntity.ok(funcionesService.obtenerTodas());
    }

    @PostMapping
    public ResponseEntity<Funciones> guardar(@RequestBody Funciones funcion) {
        return ResponseEntity.ok(funcionesService.guardar(funcion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funciones> actualizar(@PathVariable int id, @RequestBody Funciones funcion) {
        funcion.setIdFuncion(id); 
        return ResponseEntity.ok(funcionesService.actualizar(funcion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funciones> buscarPorId(@PathVariable int id) {
        Funciones funcion = funcionesService.buscarPorId(id);
        if (funcion != null) {
            return ResponseEntity.ok(funcion);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/darDeBaja/{id}")
    public ResponseEntity<?> darDeBaja(@PathVariable int id) {
        try {
            funcionesService.darDeBaja(id);
            return ResponseEntity.ok("Función dada de baja correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al dar de baja la función.");
        }
    }
}

