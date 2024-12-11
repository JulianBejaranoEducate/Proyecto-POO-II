package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Boletas;
@Repository
public interface IBoletasJpa extends JpaRepository<Boletas, Integer> {
    List<Boletas> findByEstadoBoleta(Byte estadoBoleta); // Cambiar a estadoBoleta
}