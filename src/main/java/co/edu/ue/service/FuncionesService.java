package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.dao.IFuncionesDao;
import co.edu.ue.entity.Funciones;

@Service
public class FuncionesService implements IFuncionesService {

    @Autowired
    private IFuncionesDao funcionesDao;

    @Override
    public List<Funciones> obtenerTodas() {
        return funcionesDao.listaCompleta();
    }

    @Override
    @Transactional
    public Funciones guardar(Funciones funcion) {
        return funcionesDao.guardarFuncion(funcion);
    }

    @Override
    @Transactional
    public Funciones actualizar(Funciones funcion) {
        return funcionesDao.actualizarFuncion(funcion);
    }

    @Override
    public Funciones buscarPorId(int id) {
        return funcionesDao.busquedaPorId(id);
    }

    @Override
        @Transactional
        public void darDeBaja(int id) {
        funcionesDao.darDeBajaFuncion(id);
    }
}
