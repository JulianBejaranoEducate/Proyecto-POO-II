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
    	validarDatosPelicula(pelicula);
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
    public void darDeBaja(int id) {
        Pelicula pelicula = peliculaDao.busquedaPorId(id);
        if (pelicula == null) {
            throw new IllegalArgumentException("El ID no existe");
        }
        if (pelicula.getEstadoPelicula() == 0) {
            throw new IllegalStateException("El estado del usuario es inactivo");
        }
        peliculaDao.darDeBajaPelicula(id);
    }
    
    private void validarDatosPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		
	}
}
