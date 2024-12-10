package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Usuarios;

public interface IUsuarioDao {
    List<Usuarios> listaCompleta(); 
    Usuarios guardarUsuario(Usuarios usuario); 
    Usuarios actualizarUsuario(Usuarios usuario); 
    Usuarios busquedaPorId(int id); 
    Usuarios busquedaPorEmail(String email); 
    void darDeBajaUsuario(int id);
    boolean emailExists(String email);
}