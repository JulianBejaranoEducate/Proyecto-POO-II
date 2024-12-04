package co.edu.ue.controller;

import co.edu.ue.entity.Funciones;
import co.edu.ue.service.FuncionesService;
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

import java.util.List;

@RestController
public class FuncionesController {

    @Autowired
    private FuncionesService funcionesService;

    @PostMapping(value = "funcion-sav", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funciones> postFuncion(@RequestBody Funciones funcion) {
        Funciones savedFuncion = funcionesService.guardar(funcion);
        return new ResponseEntity<>(savedFuncion, HttpStatus.CREATED);
    }

    @GetMapping(value = "funcion-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Funciones>> getAllFunciones() {
        List<Funciones> funcionesList = funcionesService.obtenerTodas();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-funciones", String.valueOf(funcionesList.size()));
        return new ResponseEntity<>(funcionesList, headers, HttpStatus.OK);
    }

    @PutMapping(value = "funcion-up")
    public ResponseEntity<Funciones> putFuncion(@RequestBody Funciones funcion) {
        Funciones updatedFuncion = funcionesService.actualizar(funcion);
        return new ResponseEntity<>(updatedFuncion, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "funcion-id")
    public ResponseEntity<Funciones> getIdFuncion(@RequestParam("id") int id) {
        Funciones funcion = funcionesService.buscarPorId(id);
        if (funcion != null) {
            return new ResponseEntity<>(funcion, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "funcion-baja")
    public ResponseEntity<String> bajaFuncion(@RequestParam("id") int id) {
        funcionesService.darDeBaja(id);
        return new ResponseEntity<>("Funcion dada de baja correctamente", HttpStatus.OK);
    }
}
