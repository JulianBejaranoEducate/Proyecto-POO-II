package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Factura;

public interface IFacturaService {
	
	List<Factura> listAll();
	Factura addFactura(Factura factura);
    Factura updateFactura(Factura factura);
    Factura findFacturaById(int id);
    void deleteFacturaById(int id);

}
