package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.dao.IFacturaDao;
import co.edu.ue.entity.Factura;

@Service
public class FacturaService implements IFacturaService {

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    public List<Factura> listAll() {
        List<Factura> facturas = facturaDao.listaCompleta();
        for (Factura factura : facturas) {
            factura.setTotal(factura.getPrecio_unitario() * factura.getCantidad());
        }
        return facturas;
    }

    @Override
    public Factura addFactura(Factura factura) {
        factura.setTotal(factura.getPrecio_unitario() * factura.getCantidad());
        return facturaDao.guardarFactura(factura);
    }

    @Override
    public Factura updateFactura(Factura factura) {
        factura.setTotal(factura.getPrecio_unitario() * factura.getCantidad());
        return facturaDao.actualizarFactura(factura);
    }

    @Override
    public Factura findFacturaById(int id) {
        Factura factura = facturaDao.encontrarFacturaId(id);
        if (factura != null) {
            factura.setTotal(factura.getPrecio_unitario() * factura.getCantidad());
        }
        return factura;
    }

    @Override
    @Transactional
    public void darDeBaja(int id) {
        facturaDao.eliminarFacturaId(id);
    }
}