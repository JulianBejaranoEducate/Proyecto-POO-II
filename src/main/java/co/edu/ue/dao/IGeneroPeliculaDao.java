package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.GeneroPelicula;

public interface IGeneroPeliculaDao {
    List<GeneroPelicula> listaCompleta();
    GeneroPelicula guardarGenero(GeneroPelicula genero);
    GeneroPelicula actualizarGenero(GeneroPelicula genero);
    GeneroPelicula busquedaPorId(int id);
    void darDeBaja(int id);
}