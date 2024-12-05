package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Pelicula;

public interface IPeliculaService {
    List<Pelicula> obtenerTodas();
    Pelicula guardar(Pelicula pelicula);
    Pelicula actualizar(Pelicula pelicula);
    Pelicula buscarPorId(int id);
    void eliminar(int id);
}
