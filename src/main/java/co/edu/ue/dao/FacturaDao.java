package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Factura;
import co.edu.ue.jpa.IFacturaJpa;

@Repository
public class FacturaDao implements IFacturaDao {

    @Autowired
    private IFacturaJpa jpa;

    @Override
    public List<Factura> listaCompleta() {
        return jpa.findByEstadoFactura((byte) 1); // Solo facturas activas
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
        Factura factura = jpa.findById(id).orElse(null);
        if (factura != null) {
            factura.setEstadoFactura((byte) 0); // Cambia el estado a inactivo
            jpa.save(factura);
        }
    }
}