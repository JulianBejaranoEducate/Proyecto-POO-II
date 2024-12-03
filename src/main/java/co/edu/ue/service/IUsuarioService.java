package co.edu.ue.service;

import java.util.List;
import co.edu.ue.entity.Usuarios;

public interface IUsuarioService {
    List<Usuarios> obtenerTodos(); 
    Usuarios guardar(Usuarios usuario); 
    Usuarios actualizar(Usuarios usuario); 
    Usuarios buscarPorId(int id); 
    Usuarios buscarPorEmail(String email);
    void darDeBaja(int id); 
}