package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Factura;

public interface IFacturaJpa extends JpaRepository<Factura, Integer>{

}
