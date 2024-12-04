package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ue.entity.Boletas;
import co.edu.ue.jpa.IBoletasJpa;

public class BoletasDao implements IBoletasDao{
	
	@Autowired
	IBoletasJpa jpa;

	@Override
	public List<Boletas> guardarBoleta(Boletas boletas) {
		jpa.save(boletas);
		return listaCompleta();
	}

	@Override
	public Boletas actualizarBoleta(Boletas boletas) {
		return jpa.save(boletas);
	}

	@Override
	public List<Boletas> listaCompleta() {
		return jpa.findAll();
	}

	@Override
	public Boletas busquedaPorId(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public void elimnarBoleta(int id) {
        jpa.deleteById(id);
	}
}
