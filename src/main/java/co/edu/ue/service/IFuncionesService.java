package co.edu.ue.service;

import java.util.List;
import co.edu.ue.entity.Funciones;

public interface IFuncionesService {
    List<Funciones> obtenerTodas(); 
    Funciones guardar(Funciones funcion); 
    Funciones actualizar(Funciones funcion); 
    Funciones buscarPorId(int id); 
    void darDeBaja(int id); 
}
