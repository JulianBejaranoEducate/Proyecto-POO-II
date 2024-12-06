package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.TipoBoleta;

public interface ITipoBoletaDao {
    TipoBoleta guardarTipoBoleta(TipoBoleta tipoBoleta);
    TipoBoleta actualizarTipoBoleta(TipoBoleta tipoBoleta);
    List<TipoBoleta> listaCompleta();
    TipoBoleta busquedaPorId(int id);
    void eliminarTipoBoleta(int id);
}
