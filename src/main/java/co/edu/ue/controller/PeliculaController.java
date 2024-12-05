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

import co.edu.ue.entity.Pelicula;
import co.edu.ue.service.IPeliculaService;

@RestController
public class PeliculaController {

    @Autowired
    private IPeliculaService peliculaService;

    @PostMapping(value = "pelicula-sav", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pelicula> postPelicula(@RequestBody Pelicula pelicula) {
        Pelicula savedPelicula = peliculaService.guardar(pelicula);
        return new ResponseEntity<>(savedPelicula, HttpStatus.CREATED);
    }

    @GetMapping(value = "pelicula-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pelicula>> getAllPeliculas() {
        List<Pelicula> peliculasList = peliculaService.obtenerTodas();
        HttpHeaders headers = new HttpHeaders();
        headers.add("cant-peliculas", String.valueOf(peliculasList.size()));
        return new ResponseEntity<>(peliculasList, headers, HttpStatus.OK);
    }

    @PutMapping(value = "pelicula-up")
    public ResponseEntity<Pelicula> putPelicula(@RequestBody Pelicula pelicula) {
        Pelicula updatedPelicula = peliculaService.actualizar(pelicula);
        return new ResponseEntity<>(updatedPelicula, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "pelicula-id")
    public ResponseEntity<Pelicula> getIdPelicula(@RequestParam("id") int id) {
        Pelicula pelicula = peliculaService.buscarPorId(id);
        if (pelicula != null) {
            return new ResponseEntity<>(pelicula, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "pelicula-delete")
    public ResponseEntity<Void> deletePelicula(@RequestParam("id") int id) {
        peliculaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
