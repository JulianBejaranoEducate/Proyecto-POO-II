	package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Boletas;

public interface IBoletasDao {
	List<Boletas> guardarBoleta(Boletas boletas);
	Boletas actualizarBoleta(Boletas boleta);
	
	// consultas
	List<Boletas> listaCompleta();
	Boletas busquedaPorId(int id);
}
