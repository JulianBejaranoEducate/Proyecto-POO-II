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

import co.edu.ue.entity.GeneroPelicula;
import co.edu.ue.service.IGeneroPeliculaService;

@RestController
@RequestMapping("/Generopelicula")
public class GeneroPeliculaController {

    @Autowired
    private IGeneroPeliculaService generoPeliculaService;


    @PostMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneroPelicula> postGenero(@RequestBody GeneroPelicula genero) {
        if (genero.getEstadoGenero() == null) {
            genero.setEstadoGenero((byte)1); 
        }
        GeneroPelicula savedGenero = generoPeliculaService.guardar(genero);
        return new ResponseEntity<>(savedGenero, HttpStatus.CREATED);
    }

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeneroPelicula>> getAllGeneros() {
        List<GeneroPelicula> generosList = generoPeliculaService.obtenerTodos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-generos", String.valueOf(generosList.size()));
        return new ResponseEntity<>(generosList, headers, HttpStatus.OK);
    }

    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneroPelicula> putGenero(@RequestBody GeneroPelicula genero) {
        if (genero.getEstadoGenero() == null) {
            genero.setEstadoGenero((byte) 1); 
        }
        GeneroPelicula updatedGenero = generoPeliculaService.actualizar(genero);
        return new ResponseEntity<>(updatedGenero, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneroPelicula> getIdGenero(@PathVariable("id") int id) {
        GeneroPelicula genero = generoPeliculaService.buscarPorId(id);
        if (genero != null) {
            return new ResponseEntity<>(genero, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> darDeBajaUsuario(@PathVariable int id) {
    try{
        generoPeliculaService.darDeBaja(id);
        return ResponseEntity.ok("Usuario dado de baja con éxito");
    } catch (IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (IllegalStateException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
}