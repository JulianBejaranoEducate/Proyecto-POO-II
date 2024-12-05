package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.dao.IPeliculaDao;
import co.edu.ue.entity.Pelicula;

@Service
public class PeliculaService implements IPeliculaService {

    @Autowired
    private IPeliculaDao peliculaDao;

    @Override
    public List<Pelicula> obtenerTodas() {
        return peliculaDao.listaCompleta();
    }

    @Override
    @Transactional
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaDao.guardarPelicula(pelicula);
    }

    @Override
    @Transactional
    public Pelicula actualizar(Pelicula pelicula) {
        return peliculaDao.actualizarPelicula(pelicula);
    }

    @Override
    public Pelicula buscarPorId(int id) {
        return peliculaDao.busquedaPorId(id);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        peliculaDao.eliminarPelicula(id);
    }
}
