package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ue.entity.Factura;
import co.edu.ue.jpa.IFacturaJpa;

public class FacturaDao implements IFacturaDao{
	
	@Autowired
	IFacturaJpa jpa;

	@Override
	public List<Factura> guardarFactura(Factura factura) {
		return null;
	}

	@Override
	public Factura actualizarFactura(Factura factura) {
		return null;
	}

	@Override
	public List<Factura> listaCompleta() {
		return null;
	}

	@Override
	public Factura busquedaPorId(int id) {
		return null;
	}
}
