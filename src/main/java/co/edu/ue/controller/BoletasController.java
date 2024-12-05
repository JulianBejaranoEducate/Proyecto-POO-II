package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.entity.Boletas;
import co.edu.ue.service.IBoletasService;

@RestController
public class BoletasController {

    @Autowired
    IBoletasService boletasService;

    @PostMapping(value = "boletas-add", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boletas> addBoleta(@RequestBody Boletas boleta) {
        Boletas savedBoleta = boletasService.addBoleta(boleta);
        return new ResponseEntity<>(savedBoleta, HttpStatus.CREATED);
    }

    @GetMapping(value = "boletas-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Boletas>> getAllBoletas() {
        List<Boletas> boletasList = boletasService.listAll();

        // Agregar información adicional en la cabecera
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Boletas", String.valueOf(boletasList.size()));

        return new ResponseEntity<>(boletasList, headers, HttpStatus.OK);
    }

    @PutMapping(value = "boletas-update")
    public ResponseEntity<Boletas> putBoleta(@RequestBody Boletas boleta) {
        return new ResponseEntity<Boletas>(boletasService.updateBoleta(boleta), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "boletas-id")
    public ResponseEntity<Boletas> getBoletaById(@RequestParam("id") int id) {
        return new ResponseEntity<Boletas>(boletasService.findBoletaById(id), HttpStatus.FOUND);
    }

    @DeleteMapping(value = "boletas-delete")
    public ResponseEntity<Void> deleteBoletaById(@RequestParam("id") int id) {
    	boletasService.deleteBoletaById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}

