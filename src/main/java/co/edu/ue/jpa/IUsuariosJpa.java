package co.edu.ue.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuarios;

@Repository
public interface IUsuariosJpa extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByEmailUser(String emailUser);
    List<Usuarios> findByEstadoUsuario(Byte estadoUsuario);
}