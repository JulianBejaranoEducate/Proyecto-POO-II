package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Funciones;
import co.edu.ue.jpa.IFuncionesJpa;

@Repository
public class FuncionesDao implements IFuncionesDao {

    @Autowired
    private IFuncionesJpa jpa;

    @Override
    public List<Funciones> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public Funciones guardarFuncion(Funciones funcion) {
        return jpa.save(funcion);
    }

    @Override
    public Funciones actualizarFuncion(Funciones funcion) {
        return jpa.save(funcion);
    }

    @Override
    public Funciones busquedaPorId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public void darDeBajaFuncion(int id) {
        Funciones funcion = jpa.findById(id).orElse(null);
        if (funcion != null) {
            funcion.setEstadoFuncion((byte) 0); 
            jpa.save(funcion); 
        }
    }
}
