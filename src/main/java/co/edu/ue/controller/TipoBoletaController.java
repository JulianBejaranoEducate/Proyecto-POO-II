package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.TipoBoleta;
import co.edu.ue.service.ITipoBoletaService;

@RestController
public class TipoBoletaController {

    @Autowired
    private ITipoBoletaService tipoBoletaService;

    @GetMapping(value = "tipoBoleta-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoBoleta>> getAllTipoBoletas() {
        List<TipoBoleta> tipoBoletasList = tipoBoletaService.obtenerTodos();
        return new ResponseEntity<>(tipoBoletasList, HttpStatus.OK);
    }


    @GetMapping(value = "tipoBoleta-id")
    public ResponseEntity<TipoBoleta> getTipoBoletaById(@RequestParam("id") int id) {
        TipoBoleta tipoBoleta = tipoBoletaService.buscarPorId(id);
        if (tipoBoleta != null) {
            return new ResponseEntity<>(tipoBoleta, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    

}
