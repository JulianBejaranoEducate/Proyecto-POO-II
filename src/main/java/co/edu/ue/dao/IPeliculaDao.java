package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Pelicula;

public interface IPeliculaDao {
    List<Pelicula> listaCompleta();
    Pelicula guardarPelicula(Pelicula pelicula);
    Pelicula actualizarPelicula(Pelicula pelicula);
    Pelicula busquedaPorId(int id);
    void darDeBajaPelicula(int id);
}
