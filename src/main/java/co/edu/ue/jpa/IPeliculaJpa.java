package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Pelicula;

@Repository
public interface IPeliculaJpa extends JpaRepository<Pelicula, Integer> {
    Pelicula findByNombre(String nombre);
    List<Pelicula> findByEstadoPelicula(Byte estadoPelicula);
}
