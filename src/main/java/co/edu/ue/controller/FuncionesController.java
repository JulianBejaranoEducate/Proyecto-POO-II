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
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Funciones;
import co.edu.ue.service.IFuncionesService;

@RestController
@RequestMapping("/funciones")
public class FuncionesController {

    @Autowired
    private IFuncionesService funcionesService;

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funciones> postFuncion(@RequestBody Funciones funcion) {
        if (funcion.getEstadoFuncion() == null) {
            funcion.setEstadoFuncion((byte)1); 
        }
        Funciones savedFuncion = funcionesService.guardar(funcion);
        return new ResponseEntity<>(savedFuncion, HttpStatus.CREATED);
    }

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Funciones>> getAllFunciones() {
        List<Funciones> funcionesList = funcionesService.obtenerTodas();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-funciones", String.valueOf(funcionesList.size()));
        return new ResponseEntity<>(funcionesList, headers, HttpStatus.OK);
    }

    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funciones> putFuncion(@RequestBody Funciones funcion) {
        if (funcion.getEstadoFuncion() == null) {
            funcion.setEstadoFuncion((byte) 1); 
        }
        Funciones updatedFuncion = funcionesService.actualizar(funcion);
        return new ResponseEntity<>(updatedFuncion, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funciones> getIdFuncion(@PathVariable("id") int id) {
        Funciones funcion = funcionesService.buscarPorId(id);
        if (funcion != null) {
            return new ResponseEntity<>(funcion, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> darDeBajaUsuario(@PathVariable int id) {
        funcionesService.darDeBaja(id);
        return new ResponseEntity<>("Funcion dada de baja correctamente", HttpStatus.OK);
    }
}