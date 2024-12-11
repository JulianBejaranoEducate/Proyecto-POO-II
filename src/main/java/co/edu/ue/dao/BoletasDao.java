package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Boletas;
import co.edu.ue.jpa.IBoletasJpa;

@Repository
public class BoletasDao implements IBoletasDao {

    @Autowired
    private IBoletasJpa jpa;

    @Override
    public List<Boletas> listaCompleta() {
        return jpa.findByEstadoBoleta((byte) 1); // Solo boletas activas
    }

    @Override
    public Boletas guardarBoleta(Boletas boleta) {
        return jpa.save(boleta);
    }

    @Override
    public Boletas actualizarBoleta(Boletas boleta) {
        return jpa.save(boleta);
    }

    @Override
    public Boletas encontrarBoletaId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public void eliminarBoletaId(int id) {
        Boletas boleta = jpa.findById(id).orElse(null);
        if (boleta != null) {
            boleta.setEstadoBoleta((byte) 0); 
            jpa.save(boleta);
        }
    }

    @Override
    public boolean boletaExists(int id) {
        return jpa.existsById(id);
    }
}