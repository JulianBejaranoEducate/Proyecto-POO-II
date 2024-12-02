package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Usuarios;

public interface IUsuariosJpa extends JpaRepository<Usuarios, Integer>{

    Usuarios findByEmailUser(String emailUser);

}
