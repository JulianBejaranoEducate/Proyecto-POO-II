package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IFacturaDao;
import co.edu.ue.entity.Factura;

@Service
public class FacturaService implements IFacturaService{
	
	@Autowired
	IFacturaDao facturaDao;

	@Override
	public List<Factura> listAll() {
		return facturaDao.listaCompleta();
	}

	@Override
	public Factura addFactura(Factura factura) {
		return facturaDao.guardarFactura(factura);
	}

	@Override
	public Factura updateFactura(Factura factura) {
		return facturaDao.guardarFactura(factura);
	}

	@Override
	public Factura findFacturaById(int id) {
		return facturaDao.encontrarFacturaId(id);
	}

	@Override
	public void deleteFacturaById(int id) {
		facturaDao.eliminarFacturaId(id);
	}
	
	

}
