package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.dao.IGeneroPeliculaDao;
import co.edu.ue.entity.GeneroPelicula;

@Service
public class GeneroPeliculaService implements IGeneroPeliculaService {

    @Autowired
    private IGeneroPeliculaDao generoPeliculaDao;

    @Override
    public List<GeneroPelicula> obtenerTodos() {
        return generoPeliculaDao.listaCompleta();
    }

    @Override
    @Transactional
    public GeneroPelicula guardar(GeneroPelicula genero) {
        return generoPeliculaDao.guardarGenero(genero);
    }

    @Override
    @Transactional
    public GeneroPelicula actualizar(GeneroPelicula genero) {
        return generoPeliculaDao.actualizarGenero(genero);
    }

    @Override
    public GeneroPelicula buscarPorId(int id) {
        return generoPeliculaDao.busquedaPorId(id);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        generoPeliculaDao.eliminarGenero(id);
    }
}
