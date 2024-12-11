package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Factura;

@Repository
public interface IFacturaJpa extends JpaRepository<Factura, Integer> {
    List<Factura> findByEstadoFactura(Byte estadoFactura); // Cambiar a estadoFactura
}