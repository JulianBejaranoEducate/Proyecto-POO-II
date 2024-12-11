package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Pelicula;
import co.edu.ue.jpa.IPeliculaJpa;

@Repository
public class PeliculaDao implements IPeliculaDao {

    @Autowired
    private IPeliculaJpa jpa;

    @Override
    public List<Pelicula> listaCompleta() {
        return jpa.findByEstadoPelicula((byte) 1);
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return jpa.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) {
        return jpa.save(pelicula);
    }

    @Override
    public Pelicula busquedaPorId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public void darDeBajaPelicula(int id) {
        Pelicula pelicula = jpa.findById(id).orElse(null);
        if (pelicula != null) {
            pelicula.setEstadoPelicula((byte) 0); 
            jpa.save(pelicula);
        }
    }
}
