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

import co.edu.ue.entity.Factura;
import co.edu.ue.service.IFacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> addFactura(@RequestBody Factura factura) {
        if (factura.getEstadoFactura() == null) {
            factura.setEstadoFactura(1); // Asigna un valor por defecto si es null
        }
        Factura savedFactura = facturaService.addFactura(factura);
        return new ResponseEntity<>(savedFactura, HttpStatus.CREATED);
    }

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Factura>> getAllFacturas() {
        List<Factura> facturaList = facturaService.listAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Facturas", String.valueOf(facturaList.size()));
        return new ResponseEntity<>(facturaList, headers, HttpStatus.OK);
    }

    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> putFactura(@RequestBody Factura factura) {
        if (factura.getEstadoFactura() == null) {
            factura.setEstadoFactura(1); // Asigna un valor por defecto si es null
        }
        Factura updatedFactura = facturaService.updateFactura(factura);
        return new ResponseEntity<>(updatedFactura, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factura> getFacturaById(@PathVariable("id") int id) {
        Factura factura = facturaService.findFacturaById(id);
        if (factura != null) {
            return new ResponseEntity<>(factura, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteFacturaById(@PathVariable("id") int id) {
        try {
            facturaService.darDeBaja(id);
            return new ResponseEntity<>("Factura eliminada correctamente", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
