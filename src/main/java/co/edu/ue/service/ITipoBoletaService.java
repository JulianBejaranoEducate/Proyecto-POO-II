package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.TipoBoleta;

public interface ITipoBoletaService {
    List<TipoBoleta> obtenerTodos();
    TipoBoleta guardar(TipoBoleta tipoBoleta);
    TipoBoleta actualizar(TipoBoleta tipoBoleta);
    TipoBoleta buscarPorId(int id);
    void eliminar(int id);
}
