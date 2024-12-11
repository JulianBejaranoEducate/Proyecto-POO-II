package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.GeneroPelicula;

public interface IGeneroPeliculaService {
    List<GeneroPelicula> obtenerTodos();
    GeneroPelicula guardar(GeneroPelicula genero);
    GeneroPelicula actualizar(GeneroPelicula genero);
    GeneroPelicula buscarPorId(int id);
    void darDeBaja(int id);
}