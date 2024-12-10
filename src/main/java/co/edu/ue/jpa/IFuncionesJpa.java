package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Funciones;
@Repository
public interface IFuncionesJpa extends JpaRepository<Funciones, Integer> {
    List<Funciones> findByEstadoFuncion(Byte estadoFuncion); // Cambiar a estadoFuncion
}
