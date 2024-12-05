package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Boletas;

public interface IBoletasDao {
    List<Boletas> listaCompleta();
    Boletas guardarBoleta(Boletas boleta);
    Boletas actualizarBoleta(Boletas boleta);
    Boletas encontrarBoletaId(int id);
    void eliminarBoletaId(int id);
}
