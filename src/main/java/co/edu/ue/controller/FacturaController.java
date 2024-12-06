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

import co.edu.ue.entity.Factura;
import co.edu.ue.service.IFacturaService;

@RestController
public class FacturaController {
	
	@Autowired
    IFacturaService facturaService;

    @PostMapping(value = "factura-add", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> addBoleta(@RequestBody Factura factura) {
        Factura savedFactura = facturaService.addFactura(factura);
        return new ResponseEntity<>(savedFactura, HttpStatus.CREATED);
    }

    @GetMapping(value = "factura-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Factura>> getAllFactura() {
        List<Factura> facturaList = facturaService.listAll();

        // Agregar información adicional en la cabecera
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-factura", String.valueOf(facturaList.size()));

        return new ResponseEntity<>(facturaList, headers, HttpStatus.OK);
    }

    @PutMapping(value = "boletas-update")
    public ResponseEntity<Factura> putBoleta(@RequestBody Factura factura) {
        return new ResponseEntity<Factura>(facturaService.updateFactura(factura), HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "boletas-id")
    public ResponseEntity<Factura> getFacturaById(@RequestParam("id") int id) {
        return new ResponseEntity<Factura>(facturaService.findFacturaById(id), HttpStatus.FOUND);
    }

    @DeleteMapping(value = "boletas-delete")
    public ResponseEntity<Void> deleteFacturaById(@RequestParam("id") int id) {
    	facturaService.deleteFacturaById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
