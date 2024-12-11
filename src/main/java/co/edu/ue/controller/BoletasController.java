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

import co.edu.ue.entity.Boletas;
import co.edu.ue.service.IBoletasService;

@RestController
@RequestMapping("/boletas")
public class BoletasController {

    @Autowired
    private IBoletasService boletasService;

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boletas> addBoleta(@RequestBody Boletas boleta) {
        if (boleta.getEstadoBoleta() == null) {
            boleta.setEstadoBoleta((byte) 1); // Asigna un valor por defecto si es null
        }
        Boletas savedBoleta = boletasService.addBoleta(boleta);
        return new ResponseEntity<>(savedBoleta, HttpStatus.CREATED);
    }

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Boletas>> getAllBoletas() {
        List<Boletas> boletasList = boletasService.listAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Boletas", String.valueOf(boletasList.size()));
        return new ResponseEntity<>(boletasList, headers, HttpStatus.OK);
    }

    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boletas> putBoleta(@RequestBody Boletas boleta) {
        if (boleta.getEstadoBoleta() == null) {
            boleta.setEstadoBoleta((byte) 1); // Asigna un valor por defecto si es null
        }
        Boletas updatedBoleta = boletasService.updateBoleta(boleta);
        return new ResponseEntity<>(updatedBoleta, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boletas> getBoletaById(@PathVariable("id") int id) {
        Boletas boleta = boletasService.findBoletaById(id);
        if (boleta != null) {
            return new ResponseEntity<>(boleta, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteBoletaById(@PathVariable("id") int id) {
        try {
            boletasService.deleteBoletaById(id);
            return new ResponseEntity<>("Boleta dada de baja correctamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
