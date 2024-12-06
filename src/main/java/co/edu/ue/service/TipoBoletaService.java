package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.dao.ITipoBoletaDao;
import co.edu.ue.entity.TipoBoleta;

@Service
public class TipoBoletaService implements ITipoBoletaService {

    @Autowired
    private ITipoBoletaDao tipoBoletaDao;

    @Override
    public List<TipoBoleta> obtenerTodos() {
        return tipoBoletaDao.listaCompleta();
    }

    @Override
    @Transactional
    public TipoBoleta guardar(TipoBoleta tipoBoleta) {
        return tipoBoletaDao.guardarTipoBoleta(tipoBoleta);
    }

    @Override
    @Transactional
    public TipoBoleta actualizar(TipoBoleta tipoBoleta) {
        return tipoBoletaDao.actualizarTipoBoleta(tipoBoleta);
    }

    @Override
    public TipoBoleta buscarPorId(int id) {
        return tipoBoletaDao.busquedaPorId(id);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        tipoBoletaDao.eliminarTipoBoleta(id);
    }
}
