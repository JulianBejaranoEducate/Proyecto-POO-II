package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.GeneroPelicula;
import co.edu.ue.jpa.IGeneroPeliculaJpa;

@Repository
public class GeneroPeliculaDao implements IGeneroPeliculaDao {

    @Autowired
    private IGeneroPeliculaJpa jpa;

    @Override
    public List<GeneroPelicula> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public GeneroPelicula guardarGenero(GeneroPelicula genero) {
        return jpa.save(genero);
    }

    @Override
    public GeneroPelicula actualizarGenero(GeneroPelicula genero) {
        return jpa.save(genero);
    }

    @Override
    public GeneroPelicula busquedaPorId(int id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public void darDeBaja(int id) {
        GeneroPelicula genero = jpa.findById(id).orElse(null);
        if (genero != null) {
            genero.setEstadoGenero((byte) 0); 
            jpa.save(genero);
        }
    }
}