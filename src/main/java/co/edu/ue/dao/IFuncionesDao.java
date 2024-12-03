package co.edu.ue.dao;

import java.util.List;
import co.edu.ue.entity.Funciones;

public interface IFuncionesDao {
    List<Funciones> listaCompleta(); 
    Funciones guardarFuncion(Funciones funcion); 
    Funciones actualizarFuncion(Funciones funcion);
    Funciones busquedaPorId(int id); 
    void eliminarFuncion(int id); 
}