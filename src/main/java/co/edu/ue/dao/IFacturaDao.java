package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Factura;

public interface IFacturaDao {
	// declaraciones de metodos abstractos o constantes
		List<Factura> guardarFactura(Factura factura);
		Factura actualizarFactura(Factura factura);
		
		// consultas
		List<Factura> listaCompleta();
		Factura busquedaPorId(int id);
}
