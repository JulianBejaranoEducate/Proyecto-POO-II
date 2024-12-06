package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.TipoBoleta;
import co.edu.ue.jpa.ITipoBoletaJpa;

@Repository
public class TipoBoletaDao implements ITipoBoletaDao {

    @Autowired
    private ITipoBoletaJpa jpa;

    @Override
    public TipoBoleta guardarTipoBoleta(TipoBoleta tipoBoleta) {
        return jpa.save(tipoBoleta); 
    }

    @Override
    public TipoBoleta actualizarTipoBoleta(TipoBoleta tipoBoleta) {
        return jpa.save(tipoBoleta);
    }

    @Override
    public List<TipoBoleta> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public TipoBoleta busquedaPorId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public void eliminarTipoBoleta(int id) {
        jpa.deleteById(id);
    }
}
