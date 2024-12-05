package co.edu.ue.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
@NamedQuery(name = "pelicula.findAll", query = "SELECT p FROM Pelicula p")
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private int idPelicula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_funcion")
    private int idFuncion;

    @Column(name = "id_genero")
    private int idGenero;

    //////////////////////////////////////////
    
    public Pelicula() {
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("idPelicula=").append(idPelicula);
        sb.append(", nombre=").append(nombre);
        sb.append(", idFuncion=").append(idFuncion);
        sb.append(", idGenero=").append(idGenero);
        sb.append('}');
        return sb.toString();
    }

}
