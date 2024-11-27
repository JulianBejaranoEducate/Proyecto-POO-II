package co.edu.ue.controller;

// import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Dato;
import co.edu.ue.service.IDatoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class DatoController {

	@Autowired
	IDatoService service;

	/*
	 * ResponseEntity "Es una clase que representa un respuesta HTTP completa"
	 */

	@PostMapping(value = "dato-sav", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dato>> postDato(@RequestBody Dato dato) {
		List<Dato> listDato = service.addDato(dato);
		return new ResponseEntity<List<Dato>>(listDato, HttpStatus.CREATED);
	}

	@GetMapping(value = "dato-all", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dato>> getAllDato() {
		// Incluir en la cabezara la cantidad de registros
		List<Dato> listDato = service.listAll();

		// 1. Instanciamos un objeto de tipo "Header" para agregar la informacion en la
		// cabecera
		HttpHeaders headears = new HttpHeaders();

		// 2. Agregamos la informacion con el metodo add
		headears.add("can't datos", String.valueOf(listDato.size()));
		headears.add("test", "valor");
		return new ResponseEntity<List<Dato>>(listDato, headears, HttpStatus.OK);
	}

	@PutMapping(value = "dato-up")
	public ResponseEntity<Dato> putDato(@RequestBody Dato dato) {
		return new ResponseEntity<Dato>(service.upDato(dato), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "dato-id")
	public ResponseEntity<Dato> getIdDato(@RequestParam("id") int id) {
		return new ResponseEntity<Dato>(service.findIdDato(id), HttpStatus.FOUND);
	}

	@GetMapping(value = "dato-email")
	public ResponseEntity<Dato> getByEmail(@RequestParam("email") String mail) {
		return new ResponseEntity<Dato>(service.findEmailDato(mail), HttpStatus.ACCEPTED);
	}
}
