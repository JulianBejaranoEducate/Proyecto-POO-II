package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Boletas;

public interface IBoletasService {
    List<Boletas> listAll(); 
    Boletas addBoleta(Boletas boleta); 
    Boletas updateBoleta(Boletas boleta); 
    Boletas findBoletaById(int id); 
    void deleteBoletaById(int id); 
    boolean boletaExists(int id);
}
