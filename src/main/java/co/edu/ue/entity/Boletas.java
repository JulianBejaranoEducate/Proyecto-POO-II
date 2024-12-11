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
@Table(name = "boletas")
@NamedQuery(name = "Boletas.findAll", query = "SELECT b FROM Boletas b")
public class Boletas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta")
    private int id_boleta;

    @Column(name = "asiento_asignado")
    private String asiento_asignado;
    
    @Column(name = "id_tipoboleta")
    private int tipoBoleta;
    
    @Column(name = "id_pelicula")
    private int pelicula;
	
	@Column(name = "estadoBoleta")
	private Byte estadoBoleta;

    public Boletas() {
    	super();
    }

	public int getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(int id_boleta) {
		this.id_boleta = id_boleta;
	}

	public String getAsiento_asignado() {
		return asiento_asignado;
	}

	public void setAsiento_asignado(String asiento_asignado) {
		this.asiento_asignado = asiento_asignado;
	}

	public int getTipoBoleta() {
		return tipoBoleta;
	}

	public void setTipoBoleta(int tipoBoleta) {
		this.tipoBoleta = tipoBoleta;
	}

	public int getPelicula() {
		return pelicula;
	}

	public void setPelicula(int pelicula) {
		this.pelicula = pelicula;
	}

	public Byte getEstadoBoleta() {
        return estadoBoleta;
    }

    public void setEstadoBoleta(Byte estadoBoleta) {
        this.estadoBoleta = estadoBoleta;
    }

	@Override
	public String toString() {
		return "Boletas [id_boleta=" + id_boleta + ", asiento_asignado=" + asiento_asignado + ", tipoBoleta="
				+ tipoBoleta + ", pelicula=" + pelicula + ", estadoBoleta=" + estadoBoleta + "]";
	}
	
}
