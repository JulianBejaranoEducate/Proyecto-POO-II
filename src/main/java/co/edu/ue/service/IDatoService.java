package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Dato;

public interface IDatoService {
	// declaraciones de metodos abstractos o constantes
	List<Dato> addDato(Dato dato);

	Dato upDato(Dato dato);

	// consultas
	List<Dato> listAll();

	Dato findIdDato(int id);

	Dato findEmailDato(String email);
}
