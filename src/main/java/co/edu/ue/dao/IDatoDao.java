package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Dato;

public interface IDatoDao {
	// declaraciones de metodos abstractos o constantes
	List<Dato> guardarDato(Dato dato);
	Dato actualizarDato(Dato dato);
	
	// consultas
	List<Dato> listaCompleta();
	Dato busquedaPorId(int id);
	Dato busquedaPorEmail(String email);
}

