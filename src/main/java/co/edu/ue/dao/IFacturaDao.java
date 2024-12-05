package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Factura;

public interface IFacturaDao {
	List<Factura> listaCompleta();
	Factura guardarFactura(Factura factura);
    Factura actualizarFactura(Factura factura);
    Factura encontrarFacturaId(int id);
    void eliminarFacturaId(int id);
}
