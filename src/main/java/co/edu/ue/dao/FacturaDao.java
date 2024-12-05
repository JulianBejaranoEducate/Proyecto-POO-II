package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ue.entity.Factura;
import co.edu.ue.jpa.IFacturaJpa;

public class FacturaDao implements IFacturaDao{
	
	@Autowired
	IFacturaJpa jpa;

	@Override
	public List<Factura> listaCompleta() {
		return jpa.findAll();
	}

	@Override
	public Factura guardarFactura(Factura factura) {
		return jpa.save(factura);
	}

	@Override
	public Factura actualizarFactura(Factura factura) {
		return jpa.save(factura);
	}

	@Override
	public Factura encontrarFacturaId(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public void eliminarFacturaId(int id) {
		jpa.deleteById(id);
		
	}

}
