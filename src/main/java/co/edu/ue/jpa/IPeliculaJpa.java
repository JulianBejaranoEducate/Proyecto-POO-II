package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Pelicula;

public interface IPeliculaJpa extends JpaRepository<Pelicula, Integer> {
    Pelicula findByNombre(String nombre);
}
