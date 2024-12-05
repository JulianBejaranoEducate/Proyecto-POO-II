package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.GeneroPelicula;
import co.edu.ue.service.IGeneroPeliculaService;

@RestController
public class GeneroPeliculaController {

    @Autowired
    private IGeneroPeliculaService generoPeliculaService;

    /**
     * Crear un nuevo género
     */
    @PostMapping(value = "genero-sav", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneroPelicula> postGenero(@RequestBody GeneroPelicula genero) {
        GeneroPelicula savedGenero = generoPeliculaService.guardar(genero);
        return new ResponseEntity<>(savedGenero, HttpStatus.CREATED);
    }

    /**
     * Obtener todos los géneros
     */
    @GetMapping(value = "genero-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeneroPelicula>> getAllGeneros() {
        List<GeneroPelicula> generosList = generoPeliculaService.obtenerTodos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-generos", String.valueOf(generosList.size()));
        return new ResponseEntity<>(generosList, headers, HttpStatus.OK);
    }

    /**
     * Actualizar un género
     */
    @PutMapping(value = "genero-up")
    public ResponseEntity<GeneroPelicula> putGenero(@RequestBody GeneroPelicula genero) {
        GeneroPelicula updatedGenero = generoPeliculaService.actualizar(genero);
        return new ResponseEntity<>(updatedGenero, HttpStatus.ACCEPTED);
    }

    /**
     * Buscar un género por ID
     */
    @GetMapping(value = "genero-id")
    public ResponseEntity<GeneroPelicula> getIdGenero(@RequestParam("id") int id) {
        GeneroPelicula genero = generoPeliculaService.buscarPorId(id);
        if (genero != null) {
            return new ResponseEntity<>(genero, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Eliminar un género por ID
     */
    @DeleteMapping(value = "genero-delete")
    public ResponseEntity<Void> deleteGenero(@RequestParam("id") int id) {
        generoPeliculaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
