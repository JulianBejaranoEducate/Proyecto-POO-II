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
@Table(name = "generos")
@NamedQuery(name = "generos.findAll", query = "SELECT g FROM GenerosPelicula g")
public class GeneroPelicula implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genero")
    private int idGenero;

    @Column(name = "nombre")
    private String nombre;

    public GeneroPelicula() {
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GeneroPelicula{");
        sb.append("idGenero=").append(idGenero);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
}
